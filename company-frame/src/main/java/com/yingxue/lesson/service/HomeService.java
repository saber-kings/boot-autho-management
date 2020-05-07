package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.resp.HomeRespVO;

/**
 * @Author: Saber污妖王
 * TODO: 首页相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/30
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface HomeService {
    HomeRespVO getHome(String userId);
}
