package com.mychanic.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.net.URI;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("API Java")
                        .version("v1")
                        .description("Teste API java - myChanic")
        );
    }

    @Bean
    public CommandLineRunner openSwagger() {
        return args -> {
            String url = "http://localhost:8080/swagger-ui.html";
            System.out.println("URL da aplicação backend: " + url);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        };
    }
}
