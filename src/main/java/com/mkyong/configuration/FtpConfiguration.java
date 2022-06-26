package com.mkyong.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
@Getter
@Component
public class FtpConfiguration {
    @Value("${ftp.url}")
    private String url;

    @Value("${ftp.port}")
    private int port;

    @Value("${ftp.username}")
    private String username;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.remotePath}")
    private String remotePath;

    @Value("${ftp.localDir}")
    private String localDir;

    @Value("${ftp.downDir}")
    private String downDir;

}
