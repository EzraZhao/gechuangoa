package com.ezra.gechuang.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ezra on 2017/8/19.
 */
public class Role implements Serializable {

    private Long rId;
    private String rName;
    private String rDescription;

    private Set<User> users = new HashSet<>();
    private Set<Privilege> privileges = new HashSet<>();

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

}
