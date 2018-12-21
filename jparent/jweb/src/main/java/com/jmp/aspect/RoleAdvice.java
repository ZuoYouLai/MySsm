package com.jmp.aspect;

import com.jmp.annotation.MyDemo;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.jpojo.DefineException;
import com.jmp.redis.JedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-03 10:35
 * @ Description：针对于权限过滤的限制
 */
@Component
@Aspect
@Slf4j
public class RoleAdvice {

    @Autowired
    private JedisService jedisService;

    //切入点
    @Pointcut(value = "@annotation(com.jmp.annotation.MyDemo)")
    private void pointcut() {

    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     * @return
     */
    @Around(value = "pointcut() && @annotation(myDemo)")
    public Object aroundMethod(ProceedingJoinPoint jp, MyDemo myDemo) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            ToolUtils.error("头部信息不能为空");
        }
        String loginKey = ToolUtils.getKey(Constant.LOGIN_INDEX, token);
        String value = jedisService.get(loginKey);
        if (StringUtils.isBlank(value)) {
            throw new DefineException(401, "token过期了请重新登录操作");
        }
        //拦截的方法
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        Object result = null;
        //执行目标方法
        result = jp.proceed();
        return result;
    }

    /**
     * 方法执行后
     * @param joinPoint
     * @param webRole
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(webRole)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, MyDemo webRole, Object result) {
        return result;
    }

    /**
     * 方法执行后 并抛出异常
     * @param joinPoint
     * @param webRole
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(webRole)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, MyDemo webRole, Exception ex) {

    }
}
