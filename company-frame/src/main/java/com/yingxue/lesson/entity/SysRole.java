package com.yingxue.lesson.entity;

import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色实体
 *
 * @author Saber污妖王
 */
@Data
public class SysRole implements Serializable {
    private String id;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private List<PermissionRespNodeVO> permissionTree;

    private static final long serialVersionUID = 1L;
}