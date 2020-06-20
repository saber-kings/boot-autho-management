package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.vo.req.DataAddReqVO;
import com.yingxue.lesson.vo.req.DataPageReqVO;
import com.yingxue.lesson.vo.req.DataUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 数据字典相关业务层接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/5/5
 * @package com.yingxue.lesson.service
 */
public interface DataService {
    /**
     * 分页查询数据字典
     *
     * @param vo 分页查询参数封装VO
     * @return 数据字典分页集合
     */
    PageRespVO<SysData> pageInfo(DataPageReqVO vo);

    /**
     * 查询对应表的数据字典
     *
     * @param dataTable 所要查询的表ID
     * @return 数据字典集合
     */
    List<SysData> selectTableOrField(Integer dataTable);

    /**
     * 添加数据字典
     *
     * @param vo 添加数据字典请求的数据VO
     * @return 添加成功的数据字典
     */
    SysData addData(DataAddReqVO vo);

    /**
     * 修改数据字典
     *
     * @param vo 修改数据字典请求的数据VO
     */
    void updateData(DataUpdateReqVO vo);

    /**
     * 根据ID删除数据字典
     *
     * @param id 数据字典ID
     */
    void deletedData(Integer id);

    /**
     * 根据ID集合批量删除数据字典
     *
     * @param ids 数据字典ID集合
     */
    void batchDeletedData(List<String> ids);
}
