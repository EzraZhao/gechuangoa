package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Privilege;
import com.ezra.gechuang.domain.Role;
import com.ezra.gechuang.service.PrivilegeService;
import com.ezra.gechuang.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有四个功能，共计6个请求：列表、删除各一个，增改各两个
 * Created by Ezra on 2017/8/20.
 */
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

    private RoleService roleService;
    private PrivilegeService privilegeService;
    private Long[] pIds;
    private Role role = new Role();

    @Override
    public Role getModel() {
        return role;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    public Long[] getpIds() {
        return pIds;
    }

    public void setpIds(Long[] pIds) {
        this.pIds = pIds;
    }

    public String addUI() {
        return "toEditPage";
    }

    public String add() {
        roleService.save(role);
        return "toList";
    }

    public String delete() {
        Long rId = role.getrId();
        Role r = roleService.findById(rId);
        if (r != null) {
            roleService.delete(r);
        }
        return "toList";
    }

    public String updateUI() {
        Long rId = role.getrId();
        Role updateRole = roleService.findById(rId);
        ActionContext.getContext().getValueStack().push(updateRole);//放在栈顶
        return "toEditPage";
    }

    public String update() {
        roleService.update(role);
        return "toList";
    }

    public String list() {
        List<Role> roles = roleService.findAll();
        ActionContext.getContext().put("roles", roles);
        return "list";
    }

    public String toSetPrivilegePage() {
        Role r = roleService.findById(role.getrId());
        ActionContext.getContext().put("role", r);

        //准备数据
        List<Privilege> topPrivileges = privilegeService.findTopList();
        ActionContext.getContext().put("topPrivileges", topPrivileges);

        //数据回显
        pIds = new Long[r.getPrivileges().size()];
        int index = 0;
        for (Privilege privilege : r.getPrivileges()) {
            pIds[index++] = privilege.getpId();
        }

        return "toSetPrivilegePage";
    }

    public String setPrivilege() {
        //从数据库中取出要修改的对象
        Role r = roleService.findById(role.getrId());
        //设置要修改的属性
        List<Privilege> privilegeList = privilegeService.findByIds("pId", pIds);
        Set<Privilege> privileges = new HashSet<>(privilegeList);
        r.setPrivileges(privileges);
        //更新
        roleService.update(r);
        return "toList";
    }

}
