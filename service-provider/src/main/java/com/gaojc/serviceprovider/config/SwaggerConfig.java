package com.gaojc.serviceprovider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger配置文件类
 * 生成的接口访问地址: http://localhost:8762/swagger-ui.html
 *
 * @author gaojc
 * @since 2019/4/9 10:25
 */
@Profile("!prod")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gaojc.serviceprovider.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的服务提供者").
                licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").version("1.0").build();
    }

}
