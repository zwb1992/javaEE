package com.spring.bean;

import java.util.Date;

/**
 * Created by zwb on 17/3/23.
 * 交易记录
 */
public class TransInfo {

    private int id; //自增id
    private int source_id;//来源用户id
    private String source_account;//来源用户名称
    private int destination_id;//目标用户id
    private String destination_account;//目标用户名称
    private double amount;//交易金额
    private Date create_at;//创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public String getSource_account() {
        return source_account;
    }

    public void setSource_account(String source_account) {
        this.source_account = source_account;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    public String getDestination_account() {
        return destination_account;
    }

    public void setDestination_account(String destination_account) {
        this.destination_account = destination_account;
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
        return "TransInfo{" +
                "id=" + id +
                ", source_id=" + source_id +
                ", source_account='" + source_account + '\'' +
                ", destination_id=" + destination_id +
                ", destination_account='" + destination_account + '\'' +
                ", amount=" + amount +
                ", create_at=" + create_at +
                '}';
    }
}
