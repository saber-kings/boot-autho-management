package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysFile;
import com.yingxue.lesson.vo.req.FilePageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 文件上传相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/9
 * @package com.yingxue.lesson.service
 */
public interface FileService {
    /**
     * 单文件上传
     * @param file      文件
     * @param userId    用户ID
     * @param type      文件类型
     * @return          上传结果
     */
    String upload(MultipartFile file, String userId, Integer type);

    /**
     * 单文件下载
     * @param fileId    文件ID
     * @param request   请求
     * @param response  响应
     */
    void download(String fileId, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据文件地址批量删除文件
     * @param fileUrls    文件地址集合
     * @return           删除文件数量
     */
    int batchDeleteByFileUrl(List<String> fileUrls);
    /**
     * 根据 ID 查询当前用户的文件数据
     * @param vo        分页参数，页码和每页条数
     * @param userId    用户ID
     * @return          文件数据集合
     */
    PageRespVO<SysFile> pageInfo(FilePageReqVO vo, String userId);

    /**
     * 根据文件名称批量删除文件
     * @param fileNames   文件名称集合
     * @param userId    用户ID
     */
    void batchDeleteMyFile(List<String> fileNames, String userId);

    /**
     * 根据用户ID删除文件
     * @param userId    用户ID
     */
    void batchDeleteByUserId(String userId);
}
