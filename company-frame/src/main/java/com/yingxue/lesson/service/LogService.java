package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.vo.req.SysLogPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 日志相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/5/1
 * @package com.yingxue.lesson.service
 */
public interface LogService {
    /**
     * 分页查询日志
     *
     * @param vo 分页查询参数封装数据VO
     * @return 日志集合
     */
    PageRespVO<SysLog> pageInfo(SysLogPageReqVO vo);

    /**
     * 根据ID集合批量删除日志
     *
     * @param logIds 日志集合
     */
    void deletedLog(List<String> logIds);
}
