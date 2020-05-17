package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Saber污妖王
 * TODO: 新增数据字典请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/22
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端新增数据字典请求提交的数据")
public class DataUpdateReqVO {
    @ApiModelProperty("字典id")
    @NotBlank(message = "字典 id 不能为空")
    private Integer id;

    @ApiModelProperty("字段或表项")
    private String dataItem;

    @ApiModelProperty("字段或表名")
    private String dataName;

    @ApiModelProperty("所属表id")
    private Integer dataTable;
}
