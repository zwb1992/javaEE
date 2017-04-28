package com.zwb.spring.dao;

/**
 * Created by zwb on 17/4/26.
 */
public interface AccountDao {

    /**
     *
     * @param account 转出用户
     * @param money 转账金额
     */
    void outMoney(String account,double money);

    /**
     *
     * @param account 转入用户
     * @param money 转账金额
     */
    void inMoney(String account,double money);
}
