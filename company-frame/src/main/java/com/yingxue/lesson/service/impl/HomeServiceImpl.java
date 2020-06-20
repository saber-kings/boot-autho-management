package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.mapper.SysDeptMapper;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.HomeService;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.vo.resp.HomeRespVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import com.yingxue.lesson.vo.resp.UserInfoRespVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 首页业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/30
 * @package com.yingxue.lesson.service.impl
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PermissionService permissionService;

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public HomeRespVO getHome(String userId) {
        HomeRespVO homeRespVO = new HomeRespVO();
        List<PermissionRespNodeVO> list = permissionService.permissionTreeList(userId);
        homeRespVO.setMenus(list);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        UserInfoRespVO vo = new UserInfoRespVO();
        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            SysDept sysDept = sysDeptMapper.selectByPrimaryKey(vo.getDeptId());
            if (sysDept != null) {
                vo.setDeptName(sysDept.getName());
            } else {
                vo.setDeptName("二次元帝国总公司");
            }
        }
        homeRespVO.setUserInfoVO(vo);
        return homeRespVO;
    }
}
