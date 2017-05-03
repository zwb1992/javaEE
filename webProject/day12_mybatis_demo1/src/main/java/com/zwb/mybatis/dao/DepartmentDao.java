package com.zwb.mybatis.dao;

import com.zwb.mybatis.bean.Department;

/**
 * Created by zwb on 17/5/2.
 */
public interface DepartmentDao {

    /**
     * 分布查询
     * @param id
     * @return
     */
    Department getDept(Integer id);


    /**
     * 根据id查询部门以及该部门下的所有员工
     * @param id
     * @return
     */
    Department getDeptAndAccounts(Integer id);


    /**
     *
     * @param id
     * @return
     */
    Department getDeptByStep(Integer id);
}
