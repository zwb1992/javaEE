package com.zwb.mybatis.dao;

import com.zwb.mybatis.bean.Account;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zwb on 17/4/27.
 * 接口式编程
 */
public interface AccountMapperAnnotation {

    @Select("select * from Account where id = #{id}")
    Account getAccountById(Integer id);
}
