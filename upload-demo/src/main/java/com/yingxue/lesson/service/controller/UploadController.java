package com.yingxue.lesson.service.controller;

import com.yingxue.lesson.service.UploadService;
import com.yingxue.lesson.vo.UploadReqVO;
import com.yingxue.lesson.vo.UploadsReqVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author Saber污妖王
 * TODO: 文件上传控制层接口
 * @editor Saber污妖王
 * @project upload-demo
 * @date 2020/6/9
 * @package com.yingxue.lesson.controller
 * @version 0.0.1
 */
@Controller
public class UploadController {
    @Resource
    private UploadService uploadService;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @GetMapping("/uploads")
    public String uploads() {
        return "uploads";
    }

    @PostMapping("/upload")
    public String uploadFile(UploadReqVO vo, Model model){
        return uploadService.upload(vo, model);
    }

    @PostMapping("/uploads")
    public String uploadFiles(UploadsReqVO vo, Model model){
        return uploadService.uploads(vo, model);
    }
}
