package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户和角色关联关系实体
 *
 * @author Saber污妖王
 */
@Data
public class SysUserRole implements Serializable {
    private String id;

    private String userId;

    private String roleId;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}