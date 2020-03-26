package com.nick.security.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author weizhong
 * @date 2020/3/25 10:51 PM
 * @package com.nick.security.aspect
 * @description
 */
@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.nick.security.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        log.info("TimeAspect, start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            log.info("arg:{}", arg);
        }
        Object obj = pjp.proceed();
        log.info("TimeAspect, end, costTime:{}", System.currentTimeMillis() - t1);
        return obj;
    }

}
