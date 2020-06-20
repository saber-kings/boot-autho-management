package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysRotationChart;
import com.yingxue.lesson.vo.req.RotationChartDeleteReqVO;
import com.yingxue.lesson.vo.req.RotationChartReqAddVO;
import com.yingxue.lesson.vo.req.RotationChartUpdateReqVO;
import com.yingxue.lesson.vo.req.RotationPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 轮播图相关业务层接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/10
 * @package com.yingxue.lesson.service
 */
public interface RotationChartService {
    /**
     * 轮播图分页查询
     *
     * @param vo 分页参数
     * @return 分页数据响应结果集
     */
    PageRespVO<SysRotationChart> pageInfo(RotationPageReqVO vo);

    /**
     * 新增轮播图
     *
     * @param vo     新增的轮播图的信息 VO
     * @param userId 用户ID
     */
    void addRotationChart(RotationChartReqAddVO vo, String userId);

    /**
     * 修改轮播图
     *
     * @param vo     修改的轮播图的信息 VO
     * @param userId 用户ID
     */
    void updateRotationChart(RotationChartUpdateReqVO vo, String userId);

    /**
     * 批量删除轮播图
     *
     * @param list 轮播图删除所需数据 VO 集合
     * @return 影响条数
     */
    int batchDeleteRotation(List<RotationChartDeleteReqVO> list);

    /**
     * 查询所有的轮播图
     *
     * @return 所有的轮播图集合
     */
    List<SysRotationChart> selectAll();

    /**
     * 根据用户ID与其管理的轮播图查询轮播图
     *
     * @param userId 用户ID
     * @return 轮播图集合
     */
    List<SysRotationChart> selectByUserId(String userId);
}
