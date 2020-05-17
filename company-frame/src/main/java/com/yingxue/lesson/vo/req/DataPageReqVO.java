package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Saber污妖王
 * TODO: 数据字典分页查询的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端分页查询数据字典请求提交的数据")
public class DataPageReqVO {
    @ApiModelProperty("当前第几页")
    private Integer pageNum = 1;
    
    @ApiModelProperty("当前页数量")
    private Integer pageSize = 10;
    
    @ApiModelProperty("id")
    private Integer id;
    
    @ApiModelProperty("字段或表项")
    private String dataItem;
    
    @ApiModelProperty("字段或表名")
    private String dataName;
    
    @ApiModelProperty("所属表id")
    private Integer dataTable;
}
