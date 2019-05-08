package com.gongjun.im.core.bean;

import java.io.Serializable;

/**
 * @Description:
 * @Author:GongJun
 * @Date:2019/1/22
 */
public class UserBean implements Serializable {
    private long serialVersionUID = 1L;
    private String username;
    private String password;
    private String role;
    private String permisision;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermisision() {
        return permisision;
    }

    public void setPermisision(String permisision) {
        this.permisision = permisision;
    }
}
