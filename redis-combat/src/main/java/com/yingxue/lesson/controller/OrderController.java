package com.yingxue.lesson.controller;

import com.yingxue.lesson.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "订单模块")
public class OrderController {
    @Autowired
    private CodeService codeService;

    @GetMapping("/order/code/{type}")
    @ApiOperation(value = "生成订单编码")
    public String getOrderCode(@PathVariable("type") String type) {
        return codeService.getOrderCode(type);
    }
}
