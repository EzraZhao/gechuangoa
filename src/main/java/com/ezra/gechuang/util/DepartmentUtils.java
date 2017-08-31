package com.ezra.gechuang.util;

import com.ezra.gechuang.domain.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ezra on 2017/8/26.
 */
public class DepartmentUtils {

    /**
     * 遍历部门树，得到所有的部门列表，并修改名称。返回层次集合
     *
     * @param topList
     * @return
     */
    public static List<Department> getAllDepartment(List<Department> topList) {
        List<Department> result = new ArrayList<>();
        walkDepartmentTrees(topList, "├", result);
        return result;
    }

    private static void walkDepartmentTrees(Collection<Department> topList, String prefix, List<Department> result) {
        for (Department department : topList) {
            //department.setdName(prefix + department.getdName());//原对象是是session中的对象，是持久化状态，所以要使用副本。
            Department copy = new Department();
            copy.setdId(department.getdId());
            copy.setdName(prefix + department.getdName());
            result.add(copy);
            walkDepartmentTrees(department.getChildren(), "　" + prefix, result);
        }
    }


}
