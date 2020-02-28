package com.zhu.springcloud.config;/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@Configuration
@EnableSwagger2
public class Swagger3 {

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("test")
                //描述
                .description("接口文档")
                //创建人
                //.contact(new Contact("LinXiuNan", "", ""))
                //版本号
                .version("1.0")
                .build();
    }
    @Bean
    public Docket commonDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用API接口文档")
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.controller"))//指向自己的controller即可
                .paths(PathSelectors.any())
                .build();
    }

}