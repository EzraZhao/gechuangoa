package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.Department;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
public interface DepartmentService {

    void save(Department department);

    Department findById(Long dId);

    void delete(Department department);

    void update(Department department);

    List<Department> findAll();

    List<Department> findChildren(Long parentId);

    List<Department> findTopList();
}
