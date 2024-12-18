package com.xinwen.minio.controller;

import com.xinwen.minio.model.ResultData;
import com.xinwen.minio.model.UploadResponse;
import com.xinwen.minio.service.MinioService;
import com.xinwen.minio.utils.MinioUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-06-23 17:16
 **/
@RestController
@Slf4j
public class TestController {
    @Autowired
    private MinioUtil minioUtil;
    @Autowired
    private MinioService minioService;

    /**
     * @author: xx
     * @date: 2022/5/25 15:32
     * @description: 上传文件
     */
    @PostMapping("/upload")
    public ResultData minioUpload(@RequestParam(value = "file") MultipartFile file){
        UploadResponse response = null;
        try {
            response = minioUtil.uploadFile(file);
        } catch (Exception e) {
            log.error("上传失败",e);
            return ResultData.error(e.getMessage());
        }
        return ResultData.success(response);
    }


    /**
     * @author: xx
     * @date: 2022/5/25 15:32
     * @description: 上传视频
     */
    @PostMapping("/uploadVideo")
    public ResultData uploadVideo(@RequestParam(value = "file") MultipartFile file){
        UploadResponse response = null;
        try {
            response = minioUtil.uploadVideo(file);
        } catch (Exception e) {
            log.error("上传失败",e);
            return ResultData.error(e.getMessage());
        }
        return ResultData.success(response);
    }

    @PostMapping("uploadFile")
    public ResultData uploadFile(@RequestParam(value = "file") MultipartFile file) {
        UploadResponse response = new UploadResponse();
        try {
            String s = minioService.uploadFile(file);
            response.setMinIoUrl(s);
            response.setNginxUrl(s);
        } catch (Exception e) {
            log.error("上传失败",e);
            return ResultData.error(e.getMessage());
        }
        return ResultData.success(response);
    }

}
