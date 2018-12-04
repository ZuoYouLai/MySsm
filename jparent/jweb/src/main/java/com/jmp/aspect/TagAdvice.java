package com.jmp.aspect;

import com.jmp.annotation.MyTag;
import com.jmp.redis.JedisService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-30 16:57
 * @ Description：
 */
@Component
@Aspect
@Slf4j
public class TagAdvice {


    @Autowired
    private JedisService jedisService;

    private final static String TAG_INDEX = "tag_list";



    //切入点
    @Pointcut(value = "@annotation(com.jmp.annotation.MyTag)")
    private void pointcut() {

    }


    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     *
     * @return
     */
    @Around(value = "pointcut() && @annotation(myTag)")
    public Object aroundMethod(ProceedingJoinPoint jp, MyTag myTag) throws Throwable {
        String methodName = jp.getSignature().getName();
        Class clazz = jp.getTarget().getClass();
        doredis();
        //拦截的方法
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        Object result = null;
        log.info("clazz  :  {}     method  :  {}", clazz, method);
        log.info("params : {}   ,    {}     ,   {}", myTag.tagContent(), myTag.tagName(), myTag.tagRole());
        //执行目标方法
        result = jp.proceed();
        doredis();
        return result;
    }

    private void doredis() {
        Long size = jedisService.incr(TAG_INDEX);
        log.info(" size  :   {}", size);
    }


    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param myTag
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(myTag)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, MyTag myTag, Object result) {

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
        log.info("执行结果：" + result);
        doredis();
        return result;
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param myTag
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(myTag)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, MyTag myTag, Exception ex) {
        doredis();
        log.error("params : {}   ,    {}     ,   {}", myTag.tagContent(), myTag.tagName(), myTag.tagRole());

    }


}
