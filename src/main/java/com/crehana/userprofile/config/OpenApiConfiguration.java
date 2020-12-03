package com.crehana.userprofile.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name="userprofileOpenApi")
    public OpenAPI bloggingOpenApi (){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("User Profile Application API")
                        .description("User Profile API implemented with Spring Boot RESTful micro-service and documented using springdoc-openapi and OpenAPI")
                );
    }
}
