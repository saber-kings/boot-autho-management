package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.vo.req.AddRoleReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

/**
 * @Author: Saber污妖王
 * TODO: 角色相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface RoleService {
    PageRespVO<SysRole> pageInfo(RolePageReqVO vo);

    SysRole addRole(AddRoleReqVO vo);
}