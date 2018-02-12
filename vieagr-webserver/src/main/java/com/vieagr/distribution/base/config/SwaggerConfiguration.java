package com.vieagr.distribution.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springfox-swagger 接口管理文档配置
 * @author master
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("vieagr-distribution")
                .genericModelSubstitutes(DeferredResult.class)
                //.genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("")//api测试请求地址
                .select()
                .paths(PathSelectors.regex("/.*"))//过滤的接口
                .build()
                .apiInfo(registerApiInfo());
    }
	
	private ApiInfo registerApiInfo() {
        Contact contact = new Contact("vieagr测试", "http://www.baidu.com/", "15008240630@163.com");
        ApiInfo apiInfo = new ApiInfo("华佗APP客户端",//大标题
                "REST风格API",//小标题
                "1.0",//版本
                "http://www.huatuooh.com/",
                contact,//作者
                "华佗主页",//链接显示文字
                "http://www.huatuooh.com/"//网站链接
        );
        return apiInfo;
    }
}
