package com.leonard.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("method: " + method + ", args: " + args);
    }

    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("after method: " + method + ", args: " + args);
    }

    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("afterReturn method: " + method + ", args: " + args);
    }

    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("afterThrowing method: " + method + ", args: " + args);
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;

        try {
            logger.info("the method: " + method + ", args: " + args);
            result = joinPoint.proceed();
            logger.info("the method: " + method + " return" + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error in method: " + method + ", args: " + args, e);
            throw e;
        }
    }

}
