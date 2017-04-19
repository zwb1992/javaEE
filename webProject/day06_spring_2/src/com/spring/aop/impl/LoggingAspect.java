package com.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by zwb on 17/4/5.
 * aop切面编程--基于注解的方式
 */
@Order(1)//如果有多个切面，可以指定切面的优先级，值越小，优先级越高
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义切入点表达式，其他的通知可以直接引用该表达式
     */
    @Pointcut("execution(public int com.spring.aop.impl.ArithmeticCalculator.*(..))")
    public void declareJoinPointExpression(){}

//    @Before("declareJoinPointExpression()")
//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("The method " + methodName + " begins..." + Arrays.asList(args));
//    }

//    @After("declareJoinPointExpression()")
//    public void afterMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends...");
//    }

//    @AfterReturning(value = "declareJoinPointExpression()",
//            returning = "result")
//    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends with result..." + result);
//    }
//
//    @AfterThrowing(value = "declareJoinPointExpression()",
//            throwing = "ex")
//    public void afterReturningMethod(JoinPoint joinPoint, Exception ex) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " occurs exception..." + ex.toString());
//    }

    /**
     * 相当于动态代理执行的全过程
     *
     * @param pdj
     */
    @Around("declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        String methodName = pdj.getSignature().getName();
        Object[] args = pdj.getArgs();
        Object result = null;
        try {
            //前置通知
            System.out.println("The method " + methodName + " begins..." + Arrays.asList(args));
            result = pdj.proceed();
            //后置通知
            System.out.println("The method " + methodName + " ends...");
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception..."+e);
        }
        //返回通知
        System.out.println("The method " + methodName + " ends with result..." + result);
        return result;
    }


}
