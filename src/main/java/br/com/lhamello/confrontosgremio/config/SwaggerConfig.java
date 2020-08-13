package br.com.lhamello.confrontosgremio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket configureAPI() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.lhamello.confrontosgremio.api.rest"))
        .paths(PathSelectors.regex("/api.*"))
        .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("Confrontos Grêmio API")
        .description("API do sistema Confrontos Grêmio")
        .version("1.0.0")
        .contact(new Contact("Luiz H. A. Mello", "htttp://localhost:8080", "email@teste.com"))
        .build();
  }
}
