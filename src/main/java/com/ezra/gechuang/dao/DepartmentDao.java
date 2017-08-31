package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.Department;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
public interface DepartmentDao extends BaseDao<Department> {
    List<Department> findChildren(Long parentId);

    List<Department> findTopList();
}
