package com.mkyong.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.configuration.FtpConfiguration;
import com.mkyong.util.FtpUtil;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/ftp")
@Slf4j(topic="请求ftp服务器")
public class FtpController {
    @Autowired
    FtpConfiguration ftpConfig;

    @GetMapping("/upload")
    public String upload() {
        String fileName = "uploadfile.txt";
        boolean result = FtpUtil.ftpUpload(fileName, ftpConfig.getUrl(),ftpConfig.getPort(),ftpConfig.getUsername(),
                ftpConfig.getPassword(), ftpConfig.getLocalDir(), ftpConfig.getRemotePath());
        if (result) {
            log.info("=======上传文件"+ fileName +"成功=======");
        } else {
            log.info("=======上传文件"+ fileName +"失败=======");
        }
        return result?"Upload Success":"Upload Failed";

    }

    @GetMapping("/download")
    public String download(){
        String fileName = "download.txt";
        boolean result = FtpUtil.ftpDownload(fileName, ftpConfig.getUrl(),ftpConfig.getPort(),ftpConfig.getUsername(),
                ftpConfig.getPassword(), ftpConfig.getRemotePath(), ftpConfig.getLocalDir() );
        if (result) {
            log.info("=======下载文件"+ fileName +"成功=======");
        } else {
            log.info("=======下载文件"+ fileName +"失败=======");
        }
        return result?"Download Success":"Download Failed";
    }


}