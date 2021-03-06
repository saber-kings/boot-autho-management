package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门实体
 *
 * @author Saber污妖王
 */
@Data
public class SysDept implements Serializable {
    private String id;

    private String deptNo;

    private String name;

    private String pid;

    private String pidName;

    private Integer status;

    private String relationCode;

    private String deptManagerId;

    private String managerName;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}