package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.vo.req.RoleAddReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.req.RoleUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 角色相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.service
 */
public interface RoleService {
    /**
     * 分页查询角色
     *
     * @param vo 分页查询参数封装VO
     * @return 角色分页集合
     */
    PageRespVO<SysRole> pageInfo(RolePageReqVO vo);

    /**
     * 添加角色
     *
     * @param vo 添加角色请求的数据VO
     * @return 添加成功的角色
     */
    SysRole addRole(RoleAddReqVO vo);

    /**
     * 查询所有角色
     *
     * @return 角色集合
     */
    List<SysRole> selectAll();

    /**
     * 根据ID查询角色详细信息
     *
     * @param id 角色ID
     * @return 角色实体
     */
    SysRole detailInfo(String id);

    /**
     * 修改角色
     *
     * @param vo 修改角色请求的数据VO
     */
    void updateRole(RoleUpdateReqVO vo);

    /**
     * 根据ID删除角色详细信息
     *
     * @param id 角色ID
     */
    void deletedRole(String id);

    /**
     * 根据用户ID查询角色名称
     *
     * @param userId 用户ID
     * @return 角色名称集合
     */
    List<String> getNamesByIds(String userId);
}
