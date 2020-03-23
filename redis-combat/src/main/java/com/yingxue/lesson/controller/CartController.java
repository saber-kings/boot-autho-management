package com.yingxue.lesson.controller;

import com.yingxue.lesson.service.CartService;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.vo.req.AddCartReqVO;
import com.yingxue.lesson.vo.resp.CartRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "购物车模块")
public class CartController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    @ApiOperation(value = "加入购物车接口")
    public String addCart(@RequestBody AddCartReqVO vo, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = (String) redisService.get(token);
        return cartService.addCart(vo, userId);
    }

    @GetMapping("/cart")
    @ApiOperation(value = "展示购物车接口")
    private List<CartRespVO> showCart(HttpServletRequest request){
        String token = request.getHeader("token");
        String userId = (String) redisService.get(token);
        return cartService.showCart(userId);
    }
}
