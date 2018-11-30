package com.jmp.web.swagger;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-28 14:54
 * @ Description：
 */

/*
 * Restful API 访问路径:
 * http://IP:port/{context-path}/swagger-ui.html
 * eg:http://localhost:8080/jd-config-web/swagger-ui.html
 */
//@EnableWebMvc
//@EnableSwagger2
//@ComponentScan(basePackages = {"com.jmp.web"})
//@Configuration
//public class RestApiConfig extends WebMvcConfigurationSupport {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.jmp.web"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("samLai APIs")
//                .termsOfServiceUrl("https://github.com/ZuoYouLai")
//                .contact(new Contact("Call me maybe","https://github.com/techa03","techa@foxmail.com"))
//                .version("1.0")
//                .build();
//    }
//}