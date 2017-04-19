package com.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zwb on 17/4/6.
 * 验证切面
 */
public class ValidateAspect {

    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("-->validate method :"+joinPoint.getSignature().getName());
    }
}
