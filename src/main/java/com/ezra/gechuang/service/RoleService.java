package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.Role;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */

public interface RoleService {


    void save(Role role);

    void delete(Role role);

    void update(Role role);

    List<Role> findAll();

    Role findById(Long rId);

    List<Role> findByIds(String idName, Long[] rIds);
}
