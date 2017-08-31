package com.ezra.gechuang.domain;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户
 * Created by Ezra on 2017/8/18.
 */
public class User implements Serializable {

    private Long uId;
    private String uName;
    private String uLoginName;
    private String uPassword;
    private Boolean uSex;
    private String uPhone;
    private String uEmail;
    private String uDescription;

    private Department uDepartment;
    private Set<Role> roles = new HashSet<>();

    /**
     * 判断用户是否有指定名称的权限
     *
     * @param privilegeName
     * @return
     */
    public Boolean hasPrivilegeByName(String privilegeName) {
        //如果是超级管理员则具有所有权限
        if (isAdmin()) {
            return true;
        }
        //其他用户要有权限才返回true
        for (Role role : roles) {
            for (Privilege privilege : role.getPrivileges()) {
                if (privilege.getpName().equals(privilegeName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断用户是否有指定url的权限
     *
     * @param privilegeUrl
     * @return
     */
    public Boolean hasPrivilegeByUrl(String privilegeUrl) {
        //如果是超级管理员则具有所有权限
        if (isAdmin()) {
            return true;
        }
        //如果以UI后缀结尾，则去掉UI
        if (privilegeUrl.endsWith("UI")) {
            privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length() - 2);
        }
        //其他用户要有权限才返回true
        List<String> allPrivilegeUrls = (List<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
        if (!allPrivilegeUrls.contains(privilegeUrl)) {
            //如果是不需要控制的权限,则所有用户都可以使用
            return true;
        }
        //如果是要控制的权限，有权限才能使用
        else {
            for (Role role : roles) {
                for (Privilege privilege : role.getPrivileges()) {
                    if (privilegeUrl.equals(privilege.getpUrl())) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    private boolean isAdmin() {
        return "admin".equals(uLoginName);
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuLoginName() {
        return uLoginName;
    }

    public void setuLoginName(String uLoginName) {
        this.uLoginName = uLoginName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Boolean getuSex() {
        return uSex;
    }

    public void setuSex(Boolean uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuDescription() {
        return uDescription;
    }

    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    public Department getuDepartment() {
        return uDepartment;
    }

    public void setuDepartment(Department uDepartment) {
        this.uDepartment = uDepartment;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
