package com.mkyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
//https://www.agilegroup.co.jp/technote/springboot-fileupload-error-handling.html
@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
public class SpringBootWebApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootWebApplication.class);
    private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
        log.info("Web Document Reference http://127.0.0.1:8080/swagger-ui/index.html");
        log.info("Server is Running on http://127.0.0.1:8080");
    }

    //Tomcat large file upload connection reset
    //http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
    /*@Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {

        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return tomcat;

    }*/

}