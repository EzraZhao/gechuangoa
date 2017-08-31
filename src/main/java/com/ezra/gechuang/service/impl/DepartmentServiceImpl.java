package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.DepartmentDao;
import com.ezra.gechuang.domain.Department;
import com.ezra.gechuang.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findById(Long dId) {
        return departmentDao.findById(dId);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> findChildren(Long parentId) {
        return departmentDao.findChildren(parentId);
    }

    @Override
    public List<Department> findTopList() {
        return departmentDao.findTopList();
    }
}
