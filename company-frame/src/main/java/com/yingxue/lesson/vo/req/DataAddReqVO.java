package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Saber污妖王
 * TODO: 新增数据字典请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/22
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端新增数据字典请求提交的数据")
public class DataAddReqVO {
    @ApiModelProperty("字段或表项")
    @NotBlank(message = "字段或表项不能为空")
    private String dataItem;

    @ApiModelProperty("字段或表名")
    @NotBlank(message = "字段或表名不能为空")
    private String dataName;

    @ApiModelProperty("所属表id")
    private Integer dataTable;
}
