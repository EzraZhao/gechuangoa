package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Department;
import com.ezra.gechuang.service.DepartmentService;
import com.ezra.gechuang.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Created by Ezra on 2017/8/20.
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private Department department = new Department();
    private DepartmentService departmentService;
    private Long parentId;

    @Override
    public Department getModel() {
        return department;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String addUI() {
        List<Department> topList = departmentService.findTopList();
        List<Department> departments = DepartmentUtils.getAllDepartment(topList);
        ActionContext.getContext().put("departments", departments);
        return "toEditPage";
    }

    public String add() {
        department.setParent(departmentService.findById(parentId));
        departmentService.save(department);
        return "toList";
    }

    public String delete() {
        Long dId = department.getdId();
        Department d = departmentService.findById(dId);
        if (d != null) {
            departmentService.delete(d);
        }
        return "toList";
    }

    public String updateUI() {
        List<Department> topList = departmentService.findTopList();
        List<Department> departments = DepartmentUtils.getAllDepartment(topList);
        ActionContext.getContext().put("departments", departments);
        Long dId = department.getdId();
        Department updateDepartment = departmentService.findById(dId);
        ActionContext.getContext().getValueStack().push(updateDepartment);//放在栈顶
        return "toEditPage";
    }

    public String update() {
        department.setParent(departmentService.findById(parentId));
        departmentService.update(department);
        return "toList";
    }

    public String list() {
        List<Department> departments = null;

        if (parentId == null) {
            departments = departmentService.findTopList();
        } else {
            departments = departmentService.findChildren(parentId);
            Department parent = departmentService.findById(parentId);
            ActionContext.getContext().put("parent", parent);
        }

        ActionContext.getContext().put("departments", departments);
        return "list";
    }

}
