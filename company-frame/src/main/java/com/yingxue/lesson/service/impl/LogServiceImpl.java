package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysLogMapper;
import com.yingxue.lesson.service.LogService;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.vo.req.SysLogPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 日志业务层实现类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public PageRespVO<SysLog> pageInfo(SysLogPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        return PageUtil.getPageVO(sysLogMapper.selectAll(vo));
    }

    @Override
    public void deletedLog(List<String> logIds) {
        int i = sysLogMapper.batchDeletedLog(logIds);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }
}
