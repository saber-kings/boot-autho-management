package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.AddCartReqVO;
import com.yingxue.lesson.vo.resp.CartRespVO;

import java.util.List;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.service
 * @version:1.0
 */
public interface CartService {
    String addCart(AddCartReqVO vo, String userId);

    List<CartRespVO> showCart(String userId);
}
