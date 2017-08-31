package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.User;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(Long id);

    void delete(User user);

    void update(User user);

    User findByNameAndPassword(String name, String password);
}
