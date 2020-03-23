package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.vo.resp
 * @version:1.0
 */
@Data
public class GoodsItemRespVO {
    @ApiModelProperty(value = "商品skuId")
    private String skuId;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "图标")
    private String icon;
}

