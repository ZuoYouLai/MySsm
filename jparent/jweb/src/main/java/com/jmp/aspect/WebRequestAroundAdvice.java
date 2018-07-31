package com.jmp.aspect;


import com.jmp.comm.RequestHolder;
import com.jmp.comm.Utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Aop的方式 可以添加对应的日志，请求的时间值
 *【这个类在正常的请求操作没有问题，但是有exception的时候，无法打印出正常的日志，
 *  跟耗时内容,故这里需要还需要写多个异常(controller,service)捕捉的aop内容。所以我个人认为用拦截器的方式会更好些】
 *
 *  2种方式进行实现日志的记录操作:
 *      1.前 中 后 异常通知的操作
 *      2.直接环绕通知操作
 *
 *
 */
@Component
@Aspect
@Slf4j
public class WebRequestAroundAdvice {

    @Pointcut("execution(public * com.jmp.controller.AspectController.*(..))")
    public void webLog(){

    }

    @Pointcut("execution(public * com.jmp.controller.AspectController.around(..))")
    public void arroundLog(){

    }


   /**
   * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
   * @return
   */
  @Around(value="arroundLog()")
  public Object aroundMethod(ProceedingJoinPoint jp){
      RequestHolder.init();
      RequestHolder.add("around : ");
      String methodName = jp.getSignature().getName();
      Object result = null;
      try {
          System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
          //执行目标方法
          result = jp.proceed();
          System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
          List list = RequestHolder.get();
          Long endTime = System.currentTimeMillis();
          log.info("content : {}  , one request time spend : {}s", JsonUtil.toJson(list),(endTime - RequestHolder.getTime()));
      } catch (Throwable e) {
          System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
      }finally {
          RequestHolder.remove();
      }
      System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
      return result;
  }







    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param joinPoint
     */
    @Before("webLog()")
    public void webBefore(JoinPoint joinPoint){
        //初始化请求的Threadlocal的日志跟时间值内容
        RequestHolder.init();
        RequestHolder.add("advice : ");
        //获取的request response 内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //获取的是request and respone
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        log.info("method name : webBefore");
        log.info("url : {}",request.getRequestURL().toString());
        log.info("class method : {} - {}",joinPoint.getSignature().getDeclaringType(),joinPoint.getSignature().getName());

    }



    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param joinPoint
     */
    @After("webLog()")
    public void webFinalAfter(JoinPoint joinPoint) {
        log.info("【后置通知】this is a afterMethod advice...");
        List list = RequestHolder.get();
        Long endTime = System.currentTimeMillis();
        log.info("content : {}  , one request time spend : {}s", JsonUtil.toJson(list),(endTime - RequestHolder.getTime()));
        RequestHolder.remove();
    }


    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "webLog()", throwing = "e")
    public void afterThrowMethod(JoinPoint joinPoint, NullPointerException e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }

}
