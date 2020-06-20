package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体
 *
 * @author Saber污妖王
 */
@Data
public class SysFile implements Serializable {
    private String id;

    private String fileUrl;

    private String fileName;

    private String extensionName;

    private String originalName;

    private Integer type;

    private String size;

    private String createId;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}