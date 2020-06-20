package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.entity.SysRotationChart;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysRotationChartMapper;
import com.yingxue.lesson.service.FileService;
import com.yingxue.lesson.service.RotationChartService;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.vo.req.RotationChartDeleteReqVO;
import com.yingxue.lesson.vo.req.RotationChartReqAddVO;
import com.yingxue.lesson.vo.req.RotationChartUpdateReqVO;
import com.yingxue.lesson.vo.req.RotationPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Saber污妖王
 * TODO: 轮播图相关业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/10
 * @package com.yingxue.lesson.service.impl
 */
@Service
public class RotationChartServiceImpl implements RotationChartService {
    @Resource
    private SysRotationChartMapper sysRotationChartMapper;

    @Resource
    private FileService fileService;

    @Override
    public PageRespVO<SysRotationChart> pageInfo(RotationPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysRotationChart> list = sysRotationChartMapper.selectAll();
        return PageUtil.getPageVO(list);
    }

    @Override
    public void addRotationChart(RotationChartReqAddVO vo, String userId) {
        SysRotationChart rotationChart = new SysRotationChart();
        BeanUtils.copyProperties(vo, rotationChart);
        rotationChart.setId(UUID.randomUUID().toString());
        rotationChart.setCreateTime(new Date());
        rotationChart.setCreateId(userId);
        int i = sysRotationChartMapper.insertSelective(rotationChart);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRotationChart(RotationChartUpdateReqVO vo, String userId) {
        SysRotationChart rotationChart = sysRotationChartMapper.selectByPrimaryKey(vo.getId());
        if (rotationChart == null) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (!rotationChart.getFileUrl().equals(vo.getFileUrl())) {
            // 首先要把文件信息表的数据删除
            // 把磁盘上的文件删除
            fileService.batchDeleteByFileUrl(Collections.singletonList(rotationChart.getFileUrl()));
        }
        BeanUtils.copyProperties(vo, rotationChart);
        rotationChart.setUpdateId(userId);
        rotationChart.setUpdateTime(new Date());
        int i = sysRotationChartMapper.updateByPrimaryKeySelective(rotationChart);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public int batchDeleteRotation(List<RotationChartDeleteReqVO> list) {
        // 删除轮播图数据
        int i = sysRotationChartMapper.batchDeleteRotation(list);
        if (list != null && !list.isEmpty()) {
            if (i == 0) {
                throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
            } else {
                // 首先删除轮播图与文件在文件信息表的数据
                // 把磁盘上的文件删除
                List<String> fileUrls = list.stream().map(RotationChartDeleteReqVO::getFileUrl).collect(Collectors.toList());
                fileService.batchDeleteByFileUrl(fileUrls);
            }
        }
        return i;
    }

    @Override
    public List<SysRotationChart> selectAll() {
        return sysRotationChartMapper.selectAll();
    }

    @Override
    public List<SysRotationChart> selectByUserId(String userId) {
        return sysRotationChartMapper.selectByUserId(userId);
    }
}
