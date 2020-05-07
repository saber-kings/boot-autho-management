package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.HomeService;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.vo.resp.HomeRespVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import com.yingxue.lesson.vo.resp.UserInfoRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 首页业务层实现类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/30
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PermissionService permissionService;

    @Override
    public HomeRespVO getHome(String userId) {
        HomeRespVO homeRespVO = new HomeRespVO();
        List<PermissionRespNodeVO> list = permissionService.permissionTreeList(userId);
        homeRespVO.setMenus(list);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        UserInfoRespVO vo = new UserInfoRespVO();
        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            vo.setDeptName("迎学教育总公司");
        }
        homeRespVO.setUserInfoVO(vo);
        return homeRespVO;
    }
}
