package com.spring.beans;

/**
 * Created by zwb on 17/4/10.
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("my name is:" + name);
    }
}
