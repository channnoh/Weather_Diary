package zerobase.weather.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//spring 3.xx 이후에는 spring-fox 대신 spring-doc사용

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("날씨 일기 프로젝트")
                        .description("날씨 일기를 CRUD 할 수 있는 백엔드 API 입니다.")
                        .version("v0.0.1"));
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
    }
}

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("title")
//                .description("description")
//                .version("1.0")
//                .build();
//    }
//}
