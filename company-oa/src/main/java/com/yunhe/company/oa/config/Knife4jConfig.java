package com.yunhe.company.oa.config;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
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
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @ClassName Knife4jConfig
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/20 15:56
 * @Version 1.0
 */
@EnableSwagger2
@EnableOpenApi
@Configuration
@EnableKnife4j
public class Knife4jConfig {
    @Bean(value = "oa-api")
    public Docket companyRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yunhe.company.oa.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("NB-OA Restful Api")
                .termsOfServiceUrl("http://www.google.com/")
                .description("<div style='font-size:14px;color:green;'>OA系统服务接口</div>")
                .contact(new Contact("伊甸园的魔法值", "https://www.google.com", "743740348@qq.com"))
                .license("Open Source")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }


}
