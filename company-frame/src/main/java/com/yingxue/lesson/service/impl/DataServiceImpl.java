package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.entity.SysDataExample;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysDataMapper;
import com.yingxue.lesson.service.DataService;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.vo.req.DataAddReqVO;
import com.yingxue.lesson.vo.req.DataPageReqVO;
import com.yingxue.lesson.vo.req.DataUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 数据字典相关业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/5/5
 * @package com.yingxue.lesson.service.impl
 */
@Service
public class DataServiceImpl implements DataService {
    @Resource
    private SysDataMapper sysDataMapper;

    @Override
    public PageRespVO<SysData> pageInfo(DataPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        SysDataExample example = new SysDataExample();
        BeanUtils.copyProperties(vo, example);
        List<SysData> list = sysDataMapper.selectByExample(example);
        return PageUtil.getPageVO(list);
    }

    @Override
    public List<SysData> selectTableOrField(Integer dataTable) {
        if (dataTable != null) {
            SysDataExample example = new SysDataExample();
            SysDataExample.Criteria criteria = example.createCriteria();
            criteria.andDataTableEqualTo(dataTable);
            return sysDataMapper.selectByExample(example);
        } else {
            return null;
        }
    }

    @Override
    public SysData addData(DataAddReqVO vo) {
        SysData sysData = new SysData();
        BeanUtils.copyProperties(vo, sysData);
        int i = sysDataMapper.insertSelective(sysData);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        return sysData;
    }

    @Override
    public void updateData(DataUpdateReqVO vo) {
        SysData sysData = new SysData();
        BeanUtils.copyProperties(vo, sysData);
        int i = sysDataMapper.updateByPrimaryKeySelective(sysData);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public void deletedData(Integer id) {
        int i = sysDataMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDeletedData(List<String> ids) {
        ids.forEach(id -> {
            int i;
            try {
                i = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                throw new BusinessException(BaseResponseCode.DATA_ERROR);
            }
            sysDataMapper.deleteByPrimaryKey(i);
        });
    }
}
