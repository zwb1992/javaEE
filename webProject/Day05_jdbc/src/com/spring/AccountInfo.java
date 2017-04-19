package com.spring;

import java.util.Date;

/**
 * Created by zwb on 17/3/23.
 */
public class AccountInfo {

    private int id;
    private String account;
    private double amount;
    private Date create_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", create_at=" + create_at +
                '}';
    }
}
