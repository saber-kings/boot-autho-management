package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.vo.req.SysLogPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 日志相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface LogService {
    PageRespVO<SysLog> pageInfo(SysLogPageReqVO vo);

    void deletedLog(List<String> logIds);
}
