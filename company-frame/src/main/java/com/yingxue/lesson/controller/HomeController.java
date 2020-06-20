package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.service.HomeService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.vo.resp.HomeRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Saber污妖王
 * TODO: 首页相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/30
 * @package com.yingxue.lesson.controller
 */
@RestController
@RequestMapping("/api")
@Api(tags = "首页模块")
public class HomeController {
    @Resource
    private HomeService homeService;

    @GetMapping("/home")
    @ApiOperation("获取首页数据接口")
    @MyLog(title = "首页模块", action = "获取首页数据接口")
    public DataResult<HomeRespVO> getHome(HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(accessToken);
        return DataResult.success(homeService.getHome(userId));
    }
}
