package com.ezra.gechuang.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ezra on 2017/8/19.
 */
public class Department implements Serializable {

    private Long dId;
    private String dName;
    private String dDescription;

    private Set<User> users = new HashSet<>();
    private Department parent;
    private Set<Department> children = new HashSet<>();

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
    }
}
