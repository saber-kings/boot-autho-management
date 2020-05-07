package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.vo.req.DeptAddReqVO;
import com.yingxue.lesson.vo.req.DeptUpdateReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 部门相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/21
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface DeptService {
    List<SysDept> selectAll();

    List<DeptRespNodeVO> deptTreeList(String deptId);

    SysDept addDept(DeptAddReqVO vo);

    void updateDept(DeptUpdateReqVO vo);

    void deletedDept(String id);
}
