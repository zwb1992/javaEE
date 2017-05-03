package com.zwb.mybatis.dao;

import com.zwb.mybatis.bean.Account;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    //封装的map key为主键值  value为实际查出的对象
    @MapKey("id")//告诉mybatis，这个Integer中封装数据库中的那个字段
    Map<Integer,Account> getAccount2Map2();


    Map<String,Object> getAccount2Map(Integer id);

    List<Account> getAccount2List();


    Account getAccountByMap(Map<String,Object> map);


    Account getAccountByIdAndName(Integer id,String name);

    Account getAccountByIdAndName1(@Param("id") Integer id, @Param("name") String name);

    long addAccount(Account account);

    boolean updateAccount(Account account);

    void deleteAccountById(Integer id);

    Account getAccountAndDept(Integer id);

    Account getAccountByStep(Integer id);


    List<Account> getAccount2ListById(Integer id);
}
