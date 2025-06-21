package com.SavePoint.SavePoint.configs;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){
        Contact contact = new Contact();
        contact.url("https://github.com/RyanGTorres/SavePoint");
        contact.name("RyanGTorres");

        Info info = new Info();

        info.title("SavePoint");
        info.version("V1");
        info.description("Uma api de reviews de catalogos de jogos");
        info.contact(contact);

        return new OpenAPI().info(info);

    }
}
