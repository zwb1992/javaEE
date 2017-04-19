package com.spring.aop.proxy;

/**
 * Created by zwb on 17/3/29.
 */
public class Main {

    public static void main(String[] args){
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator calculator1 = new ArithmeticCalculatorLoggingProxy(calculator).getArithmecticCalculator();
        calculator1.add(2,3);
    }
}
