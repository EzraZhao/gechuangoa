package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Department;
import com.ezra.gechuang.domain.Role;
import com.ezra.gechuang.domain.User;
import com.ezra.gechuang.service.DepartmentService;
import com.ezra.gechuang.service.RoleService;
import com.ezra.gechuang.service.UserService;
import com.ezra.gechuang.util.DepartmentUtils;
import com.mchange.v3.decode.DecodeUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ezra on 2017/8/20.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService userService;
    private DepartmentService departmentService;
    private RoleService roleService;
    private Long departmentId;
    private Long[] roleIds;
    private static String originalPassword;//修改时因无密码信息置空，保存原始密码

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public User getModel() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public String loginUI() {
        return "loginUI";
    }

    public String login() {
        User u = userService.findByNameAndPassword(user.getuLoginName(), user.getuPassword());
        if (u == null) {
            addFieldError("login", "用户名或密码错误");
            return "loginUI";
        } else {
            ActionContext.getContext().getSession().put("currentUser", u);
            return "toIndex";
        }
    }

    public String logout() {
        ActionContext.getContext().getSession().remove("currentUser");
        return "logout";
    }

    public String initPassword() {
        User u = userService.findById(user.getuId());
        u.setuPassword(DigestUtils.md5Hex("1234"));
        userService.update(u);
        return "toList";
    }

    public String addUI() {
        List<Department> topList = departmentService.findTopList();
        List<Department> departments = DepartmentUtils.getAllDepartment(topList);
        List<Role> roles = roleService.findAll();

        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("roles", roles);
        return "toEditPage";
    }

    public String add() {
        user.setuPassword(DigestUtils.md5Hex("1234"));
        Department department = departmentService.findById(departmentId);
        List<Role> roleList = roleService.findByIds("rId", roleIds);
        Set<Role> roleSet = new HashSet<>(roleList);

        user.setuDepartment(department);
        user.setRoles(roleSet);
        userService.save(user);
        return "toList";
    }

    public String delete() {
        User u = userService.findById(user.getuId());
        userService.delete(u);
        return "toList";
    }

    public String updateUI() {
        List<Department> topList = departmentService.findTopList();
        List<Department> departments = DepartmentUtils.getAllDepartment(topList);
        List<Role> roles = roleService.findAll();

        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("roles", roles);

        User u = userService.findById(user.getuId());
        originalPassword = u.getuPassword();
        ActionContext.getContext().getValueStack().push(u);

        roleIds = new Long[u.getRoles().size()];
        int index = 0;
        for (Role role : u.getRoles()) {
            roleIds[index++] = role.getrId();
        }

        return "toEditPage";
    }

    public String update() {
        Department department = departmentService.findById(departmentId);
        List<Role> roleList = roleService.findByIds("rId", roleIds);
        Set<Role> roleSet = new HashSet<>(roleList);

        user.setuPassword(originalPassword);
        user.setuDepartment(department);
        user.setRoles(roleSet);
        userService.update(user);
        return "toList";
    }

    public String list() {
        List<User> users = userService.findAll();
        ActionContext.getContext().put("users", users);
        return "list";
    }
}
