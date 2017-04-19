package com.spring.service;

/**
 * Created by zwb on 17/4/7.
 */
public interface BookService {

    /**
     * 买一本书，更新库存与账户余额
     * @param username
     * @param isbn
     */
    void purchase(String username,String isbn);
}
