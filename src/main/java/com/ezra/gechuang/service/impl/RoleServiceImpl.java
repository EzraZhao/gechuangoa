package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.RoleDao;
import com.ezra.gechuang.domain.Role;
import com.ezra.gechuang.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public void delete(Role role) {
        roleDao.delete(role);
    }

    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Role findById(Long rId) {
        return roleDao.findById(rId);
    }

    @Override
    public List<Role> findByIds(String idName, Long[] rIds) {
        return roleDao.findByIds(idName, rIds);
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

}
