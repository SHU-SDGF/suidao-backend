package com.tunnel.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tunnel.web.controller.BaseController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BaseController.class.getPackage().getName()))
                //.paths(PathSelectors.ant("/api/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Backend API",
                "Details of backend API calls",
                "API TOS",
                "Terms of service",
                new Contact("", "", ""),
                "License of API",
                "API license URL");
        return apiInfo;
    }
}