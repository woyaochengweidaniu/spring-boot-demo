package com.lcm.mybatisplus.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Swagger2 配置
 * </p>
 *
*/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //true可以访问swaagerUI界面
                .enable(Boolean.TRUE)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lcm.mybatisplus"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-boot-demo")
                .description("这是一个简单的 Swagger API 演示")
                .contact(new Contact("ChaoMin.Liu", "https://github.com/woyaochengweidaniu/spring", "418458127@qq.com"))
                .version("1.0.0-SNAPSHOT")
                .build();
    }

}