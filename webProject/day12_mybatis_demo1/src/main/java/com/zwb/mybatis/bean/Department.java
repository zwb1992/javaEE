package com.zwb.mybatis.bean;

import java.util.List;

/**
 * Created by zwb on 17/5/2.
 */
public class Department {
    private int id;
    private String dept_name;
    private List<Account> accounts;//一个部门里面包含多个员工

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
