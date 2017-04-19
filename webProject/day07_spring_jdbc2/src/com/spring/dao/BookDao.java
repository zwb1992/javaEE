package com.spring.dao;

/**
 * Created by zwb on 17/4/7.
 */
public interface BookDao {

    /**
     * 获取图书价格
     * @return
     */
    int getPriceByIsbn(String isbn);

    /**
     * 获取图书库存
     * @return 返回图书库存
     */
    int getStock(String isbn);

    /**
     * 更新图书库存
     * @param isbn 使图书库存-1
     */
    void updateStock(String isbn);

    /**
     * 更新账户余额
     * @param username  账户名称
     * @param price  此次操作减去的余额
     */
    void updateBalance(String username,int price);

    /**
     * 根据用户的名称获取用户余额
     * @param username 用户名称
     * @return
     */
    int getBalanceByUsername(String username);
}
