package com.dync.dao;

import com.dync.entity.User;

import java.util.List;

/**
 * @author liujipeng
 * @date 2020/11/23 14:33
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */

public interface TestMybatisDao {

    List<User> select();

    void insertSelective(User u);
}
