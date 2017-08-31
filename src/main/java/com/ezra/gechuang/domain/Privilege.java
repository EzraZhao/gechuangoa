package com.ezra.gechuang.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限实体类
 * Created by Ezra on 2017/8/27.
 */
public class Privilege implements Serializable {

    private Long pId;
    private String pUrl;
    private String pName;
    private String pIcon;

    private Set<Role> roles = new HashSet<>();
    private Privilege parent;
    private Set<Privilege> children = new HashSet<>();

    public Privilege() {
    }

    public Privilege(String pName, String pUrl, String pIcon, Privilege parent) {
        this.pName = pName;
        this.pUrl = pUrl;
        this.pIcon = pIcon;
        this.parent = parent;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpIcon() {
        return pIcon;
    }

    public void setpIcon(String pIcon) {
        this.pIcon = pIcon;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }
}
