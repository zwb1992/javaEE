package com.spring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by zwb on 17/4/5.
 * aop切面编程--基于xml的方式
 */
public class LoggingAspect {


//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("The method " + methodName + " begins..." + Arrays.asList(args));
//    }


//    public void afterMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends...");
//    }

//    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends with result..." + result);
//    }
//

//    public void afterReturningMethod(JoinPoint joinPoint, Exception ex) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " occurs exception..." + ex.toString());
//    }

    /**
     * 相当于动态代理执行的全过程
     *
     * @param pdj
     */
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
