package com.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zwb on 17/4/6.
 * 验证切面
 */
@Order(2)
@Aspect
@Component
public class ValidateAspect {

    @Before("com.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("-->validate method :"+joinPoint.getSignature().getName());
    }
}
