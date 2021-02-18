package br.com.lhamello.confrontosgremio.infraestructure.config;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.SimplePluginRegistry;

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
  @Primary
  public LinkDiscoverers discoverers() {
    return new LinkDiscoverers(SimplePluginRegistry
        .create(Stream.of(new CollectionJsonLinkDiscoverer())
        .collect(Collectors.toList())));
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(this.apiInfo())
        .useDefaultResponseMessages(false)
        .genericModelSubstitutes(ResponseEntity.class)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.lhamello.confrontosgremio.interfaces"))
        .paths(PathSelectors.regex("/api.*"))
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Confrontos Grêmio API")
        .description("API do sistema Confrontos Grêmio")
        .version("1.0.0")
        .contact(new Contact("Luiz H. A. Mello", "htttp://localhost:8080", "email@teste.com"))
        .build();
  }
}
