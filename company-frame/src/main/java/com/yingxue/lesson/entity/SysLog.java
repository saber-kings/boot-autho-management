package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体
 *
 * @author Saber污妖王
 */
@Data
public class SysLog implements Serializable {
    private String id;

    private String userId;

    private String username;

    private String operation;

    private Integer time;

    private String method;

    private String params;

    private String ip;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}