package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.dao.DepartmentDao;
import com.ezra.gechuang.domain.Department;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
@SuppressWarnings("all")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    @Override
    public List<Department> findChildren(Long parentId) {
        return (List<Department>) this.getHibernateTemplate().find("from Department where parent.dId = ?", parentId);
    }

    @Override
    public List<Department> findTopList() {
        return (List<Department>) this.getHibernateTemplate().find("from Department d where d.parent is null");
    }
}
