package com.wpp.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置Swagger的基本信息
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean("apiInfo")
    public ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring-Template Api文档",
                "后端接口的api文档",
                "v1.0.0",
                "urn:tos",
                new Contact("wpp", "https://github.com/edfeff", "edfeff@163.com"),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }

    @Bean
    public Docket docket(@Qualifier("apiInfo") ApiInfo apiInfo) {
        return new Docket(DocumentationType.SPRING_WEB)
                .apiInfo(apiInfo)
                .groupName("dev")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wpp.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket2(@Qualifier("apiInfo") ApiInfo apiInfo) {
        return new Docket(DocumentationType.SPRING_WEB)
                .apiInfo(apiInfo)
                .groupName("prod")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wpp.controller"))
                .paths(PathSelectors.any())
                .build();
    }


}
