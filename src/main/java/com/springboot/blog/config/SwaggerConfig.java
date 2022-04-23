package com.springboot.blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey() {
        return new ApiKey(
                "JWT",
                AUTHORIZATION_HEADER,
                "header"
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot Blog Rest APIs",
                "Spring Boot Blog Rest API Documentation",
                "1",
                "Terms of Service",
                new Contact(
                        "Hadi Tahmasbi",
                        null,
                        "hadit1993@gmail.com"),
                "License of API",
                "Api license URL",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global",
                "accessEverything");
        AuthorizationScope[] authorizationScopes = {authorizationScope};
        return Collections.singletonList(
                new SecurityReference(
                        "JWT",
                        authorizationScopes));
    }

}
