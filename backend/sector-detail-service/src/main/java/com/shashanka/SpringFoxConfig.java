package com.shashanka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Sector Detail API",
                "API to get and modify Sector",
                "1.0.0",
                "No T&C",
                new Contact("Shashanka Shekhar Das","google.com","gudurajasekarreddy@gmail.com"),
                "Free License",
                "google.com",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shashanka"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }
}
