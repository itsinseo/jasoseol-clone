package com.itsinseo.jasoseolclone.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("자소설닷컴 클론 코딩 API")
                .version("0.0.1")
                .description("자소설닷컴의 기능과 약간의 변형 API입니다.");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
