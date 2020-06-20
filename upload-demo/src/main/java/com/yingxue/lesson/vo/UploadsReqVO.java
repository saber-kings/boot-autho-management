package com.yingxue.lesson.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Saber污妖王
 * TODO: 多文件上传请求数据封装类
 * @editor Saber污妖王
 * @project upload-demo
 * @date 2020/6/9
 * @package com.yingxue.lesson.vo
 * @version 0.0.1
 */
@Data
public class UploadsReqVO {
    private String agentName;
    private String agentPhone;
    private MultipartFile[] businessImgs;
}
