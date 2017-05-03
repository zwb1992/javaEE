package com.zwb.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * Created by zwb on 17/4/27.
 */
@Alias("account")//在使用批量起别名，以及有两个类名相同的情况下使用它另起别名
public class Account {
    private int id;
    private String name;
    private double money;
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", department=" + department +
                '}';
    }

    public Account() {
    }

    public Account(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}
