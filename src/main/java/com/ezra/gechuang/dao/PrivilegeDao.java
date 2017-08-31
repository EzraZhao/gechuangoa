package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.Privilege;

import java.util.List;

/**
 * Created by Ezra on 2017/8/28.
 */
public interface PrivilegeDao extends BaseDao<Privilege> {
    List<Privilege> findTopList();

    List<String> findAllPrivilegeUrls();
}
