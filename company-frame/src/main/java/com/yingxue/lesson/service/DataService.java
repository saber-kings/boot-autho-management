package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.vo.req.DataAddReqVO;
import com.yingxue.lesson.vo.req.DataPageReqVO;
import com.yingxue.lesson.vo.req.DataUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/5
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface DataService {
    PageRespVO<SysData> pageInfo(DataPageReqVO vo);

    List<SysData> selectTableOrField(Integer dataTable);

    SysData addData(DataAddReqVO vo);

    void updateData(DataUpdateReqVO vo);

    void deletedData(Integer id);

    void batchDeletedData(List<String> ids);
}
