package com.spring.service;

import java.util.List;

/**
 * Created by zwb on 17/4/7.
 */
public interface Cashier {

    /**
     * 一次性买多本书，注意，在一个事务中调用另外一个事务方法，其中第一本书买成功，第二本书买失败
     * @param username
     * @param isbns
     */
    void checkout(String username, List<String> isbns);
}

