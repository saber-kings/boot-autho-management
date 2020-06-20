package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Saber污妖王
 * TODO: 新增轮播图请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/10
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端新增轮播图请求提交的数据")
public class RotationChartReqAddVO {
    @ApiModelProperty("广告地址")
    @NotBlank(message = "广告地址不能为空")
    private String url;

    @ApiModelProperty("轮播图名称")
    @NotBlank(message = "轮播图名称不能为空")
    private String name;

    @ApiModelProperty("轮播图地址")
    @NotBlank(message = "轮播图地址不能为空")
    private String fileUrl;

    @ApiModelProperty("轮播图排序位置")
    @NotNull(message = "轮播图排序位置不能为空")
    private Integer sort;

    @ApiModelProperty("轮播图描述")
    private String description;
}
