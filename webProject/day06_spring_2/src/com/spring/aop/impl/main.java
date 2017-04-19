package com.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zwb on 17/3/29.
 */
public class main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");
        ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculatorImpl");
        calculator.div(3,0);

    }
}
