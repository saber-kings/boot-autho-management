package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysFileMapper {
    /**
     * 根据ID删除文件
     *
     * @param id 文件ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入文件，这里是插入所有字段
     *
     * @param record 文件实体
     * @return 插入行数
     */
    int insert(SysFile record);

    /**
     * 插入文件，这里是插入不为空的所有字段
     *
     * @param record 文件实体
     * @return 插入行数
     */
    int insertSelective(SysFile record);

    /**
     * 根据ID查询文件
     *
     * @param id 文件ID
     * @return 文件信息
     */
    SysFile selectByPrimaryKey(String id);

    /**
     * 根据文件ID更改对应文件，这里是更改不为空的字段
     *
     * @param record 文件实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysFile record);

    /**
     * 根据文件ID更改对应文件，这里是更改所有字段
     *
     * @param record 文件实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysFile record);

    /**
     * 根据文件地址集合批量删除文件
     *
     * @param fileUrls 文件地址集合
     * @return 删除的行数
     */
    int batchDeleteByFileUrl(List<String> fileUrls);

    /**
     * 根据用户ID删除其所有文件
     *
     * @param userId 用户ID
     * @return 删除的行数
     */
    int batchDeleteByUserId(String userId);

    /**
     * 根据用户ID查询其所有文件
     *
     * @param userId 用户ID
     * @return 文件信息集合
     */
    List<SysFile> selectByUserId(String userId);

    /**
     * 根据文件名和创建用户ID批量删除文件
     *
     * @param createId 创建者用户ID
     * @param list     文件名集合
     * @return 删除的行数
     */
    int batchDeleteMyFile(@Param("createId") String createId, @Param("list") List<String> list);
}