package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.User;

/**
 * Created by Ezra on 2017/8/18.
 */
public interface UserDao extends BaseDao<User> {

    User findByNameAndPassword(String name, String password);
}
