package com.mkyong.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfiguration {
    @Value("${springfox.documentation.swagger-ui.enabled}")
    private boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(
                DocumentationType.OAS_30)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("mydlq.swagger.example.controller"))//specify package monitor config
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/error.*").negate())
                .paths(PathSelectors.regex("/actuator.*").negate())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FTP-Service-Provider")
                .description("Api Operation Socket")
                .version("0.0.1")
                .license("MIT LICENSE 2.0")
                .licenseUrl("https://github.com/fan9704")
                .contact(new Contact("FKT", "https://github.com/fan9704", "cxz123499@gmail.com"))
                .build();
    }

}