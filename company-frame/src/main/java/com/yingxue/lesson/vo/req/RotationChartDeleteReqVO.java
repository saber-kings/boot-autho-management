package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Saber污妖王
 * TODO: 删除轮播图请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/12
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端删除轮播图请求提交的数据")
public class RotationChartDeleteReqVO {
    @ApiModelProperty(value = "轮播图id")
    @NotBlank(message = "轮播图id不能为空")
    private String id;

    @ApiModelProperty(value = "轮播图图片地址")
    @NotBlank(message = "轮播图图片地址不能为空")
    private String fileUrl;
}
