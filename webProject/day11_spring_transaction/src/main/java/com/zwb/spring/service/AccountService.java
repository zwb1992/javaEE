package com.zwb.spring.service;

/**
 * Created by zwb on 17/4/26.
 */
public interface AccountService {

    /**
     *
     * @param from 要转出的账号
     * @param to 要转入的账户
     * @param money 转账的金额
     */
    void transfer(String from,String to,double money);
}
