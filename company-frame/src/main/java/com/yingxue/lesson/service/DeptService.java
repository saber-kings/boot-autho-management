package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.vo.req.AddDeptReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 部门业务层接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/21
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface DeptService {
    List<SysDept> selectAll();

    List<DeptRespNodeVO> deptTreeList();

    SysDept addDept(AddDeptReqVO vo);
}
