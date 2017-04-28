package com.zwb.spring.service;

import com.zwb.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by zwb on 17/4/26.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //注入编程式事务管理类
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 编程式事务管理实现方式
     * @param from
     * @param to
     * @param money
     */
    public void transfer1(final String from, final String to, final double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(from,money);
                int i = 1/0;
                accountDao.inMoney(to,money);
            }
        });
    }

    public void transfer(String from, String to, double money) {
        accountDao.outMoney(from,money);
        accountDao.inMoney(to,money);
    }

    /**
     * 基于xml的方式实现事务
     * @param from
     * @param to
     * @param money
     */
    public void transfer2(String from, String to, double money) {
        accountDao.outMoney(from,money);
        accountDao.inMoney(to,money);
    }


    /**
     * 基于注解的方式实现事务
     * @param from
     * @param to
     * @param money
     */
    @Transactional
    public void transfer3(String from, String to, double money) {
        accountDao.outMoney(from,money);
        accountDao.inMoney(to,money);
    }
}
