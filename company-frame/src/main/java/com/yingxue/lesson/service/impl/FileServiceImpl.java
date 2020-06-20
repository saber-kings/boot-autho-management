package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysFile;
import com.yingxue.lesson.entity.SysRotationChart;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysFileMapper;
import com.yingxue.lesson.mapper.SysRotationChartMapper;
import com.yingxue.lesson.service.FileService;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.vo.req.FilePageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Saber污妖王
 * TODO: 文件上传相关业务接口实体类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/9
 * @package com.yingxue.lesson.service.impl
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Value("${file.path}")
    private String filePath;

    @Value("${file.base-url}")
    private String baseUrl;

    @Resource
    private SysFileMapper sysFileMapper;

    @Resource
    private SysRotationChartMapper sysRotationChartMapper;

    @Override
    public String upload(MultipartFile file, String userId, Integer type) {
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename != null) {
                String extensionName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
                String fileId = UUID.randomUUID().toString();
                String fileName = fileId + "." + extensionName;
                File destFile = new File(filePath + fileName);
                if (!destFile.getParentFile().exists()) {
                    boolean mkdirs = destFile.getParentFile().mkdirs();
                    if (!mkdirs) {
                        log.error("文件夹创建失败");
                        throw new BusinessException(BaseResponseCode.UPLOAD_FILE_ERROR);
                    }
                }
                String fileUrl = baseUrl + fileName;
                try {
                    log.info("baseUrl: {}", fileUrl);
                    file.transferTo(destFile);
                    SysFile sysFile = new SysFile();
                    sysFile.setId(UUID.randomUUID().toString());
                    sysFile.setFileName(fileName);
                    sysFile.setExtensionName(extensionName);
                    sysFile.setOriginalName(originalFilename);
                    sysFile.setCreateId(userId);
                    sysFile.setType(type);
                    sysFile.setFileUrl(fileUrl);
                    sysFile.setSize(FileUtils.byteCountToDisplaySize(file.getSize()));
                    sysFile.setCreateTime(new Date());
                    int i = sysFileMapper.insertSelective(sysFile);
                    if (i != 1) {
                        throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
                    }
                } catch (IOException e) {
                    log.error("文件上传错误, Exception: {}", e.getLocalizedMessage());
                    throw new BusinessException(BaseResponseCode.UPLOAD_FILE_ERROR);
                }
                return fileUrl;
            } else {
                log.error("文件名称不能为空");
                throw new BusinessException(BaseResponseCode.UPLOAD_FILE_NAME_NOT_NULL);
            }
        } else {
            log.error("没有接收到文件");
            throw new BusinessException(BaseResponseCode.UPLOAD_FILE_NOT_NULL);
        }
    }

    @Override
    public void download(String fileId, HttpServletRequest request, HttpServletResponse response) {
        SysFile sysFile = sysFileMapper.selectByPrimaryKey(fileId);
        if (sysFile == null) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        try {
            String agent = request.getHeader("User-Agent");
            String fileName = sysFile.getOriginalName();
            if (agent.contains(Constant.IE_BROWSER_KEY)) {
                // IE浏览器
                fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
                fileName = fileName.replace("+", " ");
            } else if (agent.contains(Constant.FIREFOX_BROWSER_KEY)) {
                // 火狐浏览器
                fileName = "=?utf-8?B?" + Base64.encodeToString(fileName.getBytes(StandardCharsets.UTF_8)) + "?=";
            } else {
                // 其它浏览器
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
            response.setHeader("content-disposition", String.format("attachment;filename=%s", fileName));
        } catch (Exception e) {
            log.error("Exception: {}", e.getLocalizedMessage());
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            File file = new File(filePath + sysFile.getFileName());
            @Cleanup ServletOutputStream out = response.getOutputStream();
            IOUtils.write(FileUtils.readFileToByteArray(file), out);
        } catch (IOException e) {
            log.error("IOException: {}", e.getLocalizedMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchDeleteByFileUrl(List<String> fileUrls) {
        // 删除了文件信息表里面的数据
        int i = sysFileMapper.batchDeleteByFileUrl(fileUrls);
        fileUrls.forEach(fileUrl -> {
            String fileName = fileUrl.substring(baseUrl.length());
            //删除磁盘文件
            boolean isDelete = deleteDestFile(fileName);
            if (!isDelete) {
                log.error("磁盘文件删除失败，文件名称: {}", fileName);
                throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
            }
        });
        return i;
    }

    /**
     * 根据文件名删除磁盘文件
     *
     * @param fileName 文件名
     * @return 删除结果
     */
    private boolean deleteDestFile(String fileName) {
        File file = new File(filePath + fileName);
        if (file.exists()) {
            return file.delete();
        } else {
            return true;
        }
    }

    @Override
    public PageRespVO<SysFile> pageInfo(FilePageReqVO vo, String userId) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysFile> sysFiles = sysFileMapper.selectByUserId(userId);
        return PageUtil.getPageVO(sysFiles);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchDeleteMyFile(List<String> fileNames, String userId) {
        int i = sysFileMapper.batchDeleteMyFile(userId, fileNames);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        } else {
            fileNames.forEach(fileName -> {
                //删除磁盘文件
                boolean isDelete = deleteDestFile(fileName);
                if (!isDelete) {
                    log.error("磁盘文件删除失败，文件名称: {}", fileName);
                    throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
                }
            });
        }
    }

    @Override
    public void batchDeleteByUserId(String userId) {
        //查询该用户上传的所有文件
        List<SysFile> sysFiles = sysFileMapper.selectByUserId(userId);
        //如果该用户存在上传的文件
        if (!sysFiles.isEmpty()) {
            List<String> allFileUrls = sysFiles.stream()
                    .map(SysFile::getFileUrl)
                    .collect(Collectors.toList());
            //查询该用户操作过的轮播图
            List<SysRotationChart> rotationCharts = sysRotationChartMapper.selectByUserId(userId);
            List<String> finalFileUrls = null;
            //如果该用户存在操作过的轮播图
            if (!rotationCharts.isEmpty()) {
                //过滤出该用户操作的轮播图关联的文件
                List<String> userOwnRotation = rotationCharts.stream().map(rotationChart -> {
                    if (rotationChart.getUpdateId() != null && rotationChart.getUpdateId().equals(userId)) {
                        return rotationChart.getFileUrl();
                    } else if (rotationChart.getUpdateId() == null) {
                        if (rotationChart.getCreateId().equals(userId)) {
                            return rotationChart.getFileUrl();
                        }
                    }
                    return null;
                }).filter(Objects::nonNull).collect(Collectors.toList());
                //从要删除的该用户上传的所有文件中去除轮播图正在使用的文件，该部分删掉会影响轮播图的显示
                finalFileUrls = allFileUrls.stream()
                        .filter(item -> !userOwnRotation.contains(item))
                        .collect(Collectors.toList());
            }
            //最后删除该用户上传的除正在使用以外的其他所有文件（若不为空的话）
            batchDeleteByFileUrl(Objects.requireNonNullElse(finalFileUrls, allFileUrls));
        }
    }

}
