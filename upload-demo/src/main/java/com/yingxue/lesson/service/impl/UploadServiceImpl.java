package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.service.UploadService;
import com.yingxue.lesson.vo.UploadReqVO;
import com.yingxue.lesson.vo.UploadsReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Saber污妖王
 * TODO: 文件上传服务层业务接口实现类
 * @editor Saber污妖王
 * @project upload-demo
 * @date 2020/6/9
 * @package com.yingxue.lesson.service.impl
 * @version 0.0.1
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    @Value("${file.path}")
    private String filePath;

    @Override
    public String upload(UploadReqVO vo, Model model) {
        log.info("agentPhone={}", vo.getAgentPhone());
        log.info("agentName={}", vo.getAgentName());
        if (vo.getBusinessImg().isEmpty()||vo.getBusinessImg()==null) {
            model.addAttribute("message","上传失败");
            return "success";
        }
        try {
            byte[] bytes = vo.getBusinessImg().getBytes();
            boolean exists = checkDirExists(filePath);
            if (!exists) {
                log.info("上传路径：{}，不存在，已创建", filePath);
            }
            Path path = Paths.get(filePath + vo.getBusinessImg().getOriginalFilename());
            Files.write(path, bytes);
            model.addAttribute("message",vo.getBusinessImg().getOriginalFilename()+"，上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public String uploads(UploadsReqVO vo, Model model) {
        log.info("agentPhone={}", vo.getAgentPhone());
        log.info("agentName={}", vo.getAgentName());
        boolean exists = checkDirExists(filePath);
        if (!exists) {
            log.info("上传路径：{}，不存在，已创建", filePath);
        }
        try {
            for (MultipartFile file : vo.getBusinessImgs()) {
                if (file.isEmpty()) {
                    model.addAttribute("message","上传失败");
                    return "success";
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(filePath + file.getOriginalFilename());
                Files.write(path, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("message","多个文件上传成功");
        return "success";
    }

    /**
     * 判断文件夹是否存在，不存在就创建，
     * 如果传入的是文件路径并且该文件已存在，则返回true并打印日志
     * @param path 文件(夹)路径
     * @return 如果存在就返回true，不存在就返回false
     */
    private boolean checkDirExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                log.info("目录存在");
            } else {
                log.info("同名文件存在, 不能创建");
            }
        } else {
            log.info("目录不存在，创建目录");
            return !file.mkdirs();
        }
        return true;
    }
}
