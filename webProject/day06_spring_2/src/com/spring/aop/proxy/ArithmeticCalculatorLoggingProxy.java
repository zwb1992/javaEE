package com.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zwb on 17/3/29.
 */
public class ArithmeticCalculatorLoggingProxy {

    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getArithmecticCalculator() {
        ArithmeticCalculator proxy;
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] classes = new Class[]{ArithmeticCalculator.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("The method begins whit:" + methodName + ":" + args);
                Object result = method.invoke(target, args);
                System.out.println("The method ends whit:" + result);
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, classes, handler);
        return proxy;
    }
}
