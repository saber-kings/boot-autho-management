package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.resp.HomeRespVO;

/**
 * @author Saber污妖王
 * TODO: 首页相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/30
 * @package com.yingxue.lesson.service
 */
public interface HomeService {
    /**
     * 根据用户ID查询首页信息（菜单权限和用户基本信息）
     *
     * @param userId 用户ID
     * @return 首页信息
     */
    HomeRespVO getHome(String userId);
}
