package com.yingxue.lesson.entity;

import java.io.Serializable;

public class SysData implements Serializable {
    private Integer id;

    private String dataItem;

    private String dataName;

    private Integer dataTable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataItem() {
        return dataItem;
    }

    public void setDataItem(String dataItem) {
        this.dataItem = dataItem == null ? null : dataItem.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public Integer getDataTable() {
        return dataTable;
    }

    public void setDataTable(Integer dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dataItem=").append(dataItem);
        sb.append(", dataName=").append(dataName);
        sb.append(", dataTable=").append(dataTable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}