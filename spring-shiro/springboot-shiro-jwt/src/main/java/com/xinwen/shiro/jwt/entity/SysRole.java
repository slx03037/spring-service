package com.xinwen.shiro.jwt.entity;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-05-08 14:44
 **/


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description  : 角色信息
 */
@Data
public class SysRole extends Role implements Serializable {


    private static final long serialVersionUID = 5354178453948664341L;
    // 拥有的权限列表
    private List<Permission> permissions;

    public SysRole() {
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}

