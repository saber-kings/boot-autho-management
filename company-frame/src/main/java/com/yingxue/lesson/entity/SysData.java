package com.yingxue.lesson.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据字典实体
 *
 * @author Saber污妖王
 */
@Data
public class SysData implements Serializable {
    private Integer id;

    private String dataItem;

    private String dataName;

    private Integer dataTable;

    private static final long serialVersionUID = 1L;
}