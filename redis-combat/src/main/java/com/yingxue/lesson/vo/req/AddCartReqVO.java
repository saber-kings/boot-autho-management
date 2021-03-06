package com.yingxue.lesson.vo.req;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
* @ClassName: AddCartReqVO
* TODO:类文件简单描述
* @Author: 小霍
* @UpdateUser: 小霍
* @Version: 0.0.1
*/
@Data
@ApiModel(value = "com.yingxue.lesson.vo.req.AddCartReqVO", description = "接收添加购物车数据的VO")
public class AddCartReqVO {
    @ApiModelProperty(value = "商品skuId")
    private String sukId;
    @ApiModelProperty(value = "属性规格id拼接集合(以逗号隔开)")
    private String specificationIds;
    @ApiModelProperty(value = "加入购物车商品数量")
    private Integer num;
}