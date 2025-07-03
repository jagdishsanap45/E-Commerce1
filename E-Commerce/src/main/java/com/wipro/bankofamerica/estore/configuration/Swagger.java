//package com.wipro.bankofamerica.estore.configuration;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.Contact;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Swagger {
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("E-Commerce")
//                        .version("1.0")
//                        .description("This is a Swagger Documention For E-Commerce.")
//                        .contact(new Contact()
//                                .name("Developed By Jagdish")
//                                .email(" jagdishsanap321@gmail.com")
//                                .url(" ")));
//    }
//
//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("public-api")
//                .pathsToMatch("/api/**")
//                .build();
//    }
//}
//
