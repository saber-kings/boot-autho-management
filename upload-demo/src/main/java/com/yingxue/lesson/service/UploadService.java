package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.UploadReqVO;
import com.yingxue.lesson.vo.UploadsReqVO;
import org.springframework.ui.Model;

/**
 * @author Saber污妖王
 * TODO: 文件上传服务层业务接口
 * @editor Saber污妖王
 * @project upload-demo
 * @date 2020/6/9
 * @package com.yingxue.lesson.service
 * @version 0.0.1
 */
public interface UploadService {
    String upload(UploadReqVO vo, Model model);

    String uploads(UploadsReqVO vo, Model model);
}
