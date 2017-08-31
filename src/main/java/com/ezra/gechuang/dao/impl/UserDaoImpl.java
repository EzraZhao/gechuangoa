package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.dao.UserDao;
import com.ezra.gechuang.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ezra on 2017/8/18.
 */
@SuppressWarnings("all")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByNameAndPassword(String name, String password) {
        List<User> users = (List<User>) this.getHibernateTemplate().find("from User where uLoginName=? and uPassword=?", name, DigestUtils.md5Hex(password));
        if (users != null && users.size() != 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
