package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色和菜单权限关联关系实体
 *
 * @author Saber污妖王
 */
@Data
public class SysRolePermission implements Serializable {
    private String id;

    private String roleId;

    private String permissionId;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}