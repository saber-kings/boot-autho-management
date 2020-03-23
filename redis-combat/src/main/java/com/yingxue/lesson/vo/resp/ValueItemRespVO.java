package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.vo.resp
 * @version:1.0
 */
@Data
@ApiModel(value = "com.yingxue.lesson.vo.resp.ValueItemRespVO", description = "规格属性的VO")
public class ValueItemRespVO {
    @ApiModelProperty(value = "商品规格属性id")
    private String valueId;
    @ApiModelProperty(value = "商品规格属性名称")
    private String valueName;
    @ApiModelProperty(value ="商品规格属性类型名称")
    private String typeName;
    @ApiModelProperty(value = "商品规格属性类型")
    private String type;
}
