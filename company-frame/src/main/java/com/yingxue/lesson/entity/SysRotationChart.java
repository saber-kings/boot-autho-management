package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图实体
 *
 * @author Saber污妖王
 */
@Data
public class SysRotationChart implements Serializable {
    private String id;

    private String url;

    private String name;

    private String fileUrl;

    private Integer sort;

    private String description;

    private String createId;

    private String updateId;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}