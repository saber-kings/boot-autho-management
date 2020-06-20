package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.vo.req.DeptAddReqVO;
import com.yingxue.lesson.vo.req.DeptUpdateReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 部门相关业务层接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/21
 * @package com.yingxue.lesson.service
 */
public interface DeptService {
    /**
     * 查询所有部门
     *
     * @return 部门集合
     */
    List<SysDept> selectAll();

    /**
     * 根据部门ID查询所有上级部门=树列表
     *
     * @param deptId 部门ID
     * @return 部门树节点集合
     */
    List<DeptRespNodeVO> deptTreeList(String deptId);

    /**
     * 添加部门
     *
     * @param vo 添加部门请求的数据VO
     * @return 添加成功的部门
     */
    SysDept addDept(DeptAddReqVO vo);

    /**
     * 修改部门
     *
     * @param vo 修改部门请求的数据VO
     */
    void updateDept(DeptUpdateReqVO vo);

    /**
     * 根据ID删除部门
     *
     * @param id 部门ID
     */
    void deletedDept(String id);
}
