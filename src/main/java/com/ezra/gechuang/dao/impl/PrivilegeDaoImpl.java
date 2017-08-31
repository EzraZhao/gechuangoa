package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.dao.PrivilegeDao;
import com.ezra.gechuang.domain.Privilege;

import java.util.List;

/**
 * Created by Ezra on 2017/8/28.
 */
@SuppressWarnings("all")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

    @Override
    public List<Privilege> findTopList() {
        return (List<Privilege>) this.getHibernateTemplate().find("from Privilege p where p.parent is null");
    }

    @Override
    public List<String> findAllPrivilegeUrls() {
        return (List<String>) this.getHibernateTemplate().find("select distinct p.pUrl from Privilege p where p.pUrl is not null");
    }
}
