package com.xkcoding.upload.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.xkcoding.upload.service.StorageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 文件上传 Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-06 16:33
 */
@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;


    private final StorageService qiNiuService;

    @Autowired
    public UploadController(StorageService qiNiuService) {
        this.qiNiuService = qiNiuService;
    }

    @PostMapping(value = "/local", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Dict local(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Dict.create().set("code", 400).set("message", "文件内容为空");
        }

       this.qiNiuService.uploadFile(file);
        return Dict.create().set("code", 200).set("message", "上传成功");
    }

}
