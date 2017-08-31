package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.PrivilegeDao;
import com.ezra.gechuang.domain.Privilege;
import com.ezra.gechuang.service.PrivilegeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/8/28.
 */
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    private PrivilegeDao privilegeDao;

    public void setPrivilegeDao(PrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;
    }

    @Override
    public List<Privilege> findAll() {
        return privilegeDao.findAll();
    }

    @Override
    public List<Privilege> findByIds(String idName, Long[] pIds) {
        return privilegeDao.findByIds(idName, pIds);
    }

    @Override
    public List<Privilege> findTopList() {
        return privilegeDao.findTopList();
    }

    @Override
    public List<String> findAllPrivilegeUrls() {
        return privilegeDao.findAllPrivilegeUrls();
    }
}
