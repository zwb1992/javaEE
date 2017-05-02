package com.zwb.mybatis.dao;

import com.zwb.mybatis.bean.Account;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by zwb on 17/4/27.
 * 接口式编程
 */
public interface AccountMapper {

    /**
     * 用这个方法去与AccountMapper.xml里面的sql绑定
     * @param id
     * @return
     */
    Account getAccountById(Integer id);


    Account getAccountByMap(Map<String,Object> map);


    Account getAccountByIdAndName(Integer id,String name);

    Account getAccountByIdAndName1(@Param("id") Integer id, @Param("name") String name);

    long addAccount(Account account);

    boolean updateAccount(Account account);

    void deleteAccountById(Integer id);
}
