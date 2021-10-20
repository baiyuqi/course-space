package com.xkcoding.upload.service.impl;

import com.xkcoding.upload.service.StorageService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 七牛云上传Service
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-06 17:22
 */
@Service
@Slf4j
public class LocalServiceImpl implements StorageService {

    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;

    /**
     * 七牛云上传文件
     *
     * @param file 文件
     * @return 七牛上传Response
     * @throws QiniuException 七牛异常
     */
    @Override
    public void uploadFile(MultipartFile file)  {
    	  String fileName = file.getOriginalFilename();
          String rawFileName = StrUtil.subBefore(fileName, ".", true);
          String fileType = StrUtil.subAfter(fileName, ".", true);
          String localFilePath = StrUtil.appendIfMissing(fileTempPath, "/") + rawFileName + "-" + DateUtil.current(false) + "." + fileType;
  
              try {
				file.transferTo(new File(localFilePath));
			} catch (Exception e) {
				throw new RuntimeException(e);
			
			}
         

    }

}
