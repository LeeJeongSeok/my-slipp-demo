package com.lee.practice.myslippdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class MySlippDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySlippDemoApplication.class, args);
    }

    @Bean
    public Docket newApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/greeting.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Rest Sample with Swagger")
                .description("Spring Rest Sample with Swagger")
                .termsOfServiceUrl("")
                .contact("")
                .license("")
                .licenseUrl("")
                .version("")
                .build();
    }




}
