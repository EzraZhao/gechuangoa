package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.UserDao;
import com.ezra.gechuang.domain.User;
import com.ezra.gechuang.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return userDao.findByNameAndPassword(name, password);
    }
}
