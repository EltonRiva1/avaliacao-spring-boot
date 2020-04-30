package br.com.tokiomarine.seguradora.avaliacao.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.tokiomarine.seguradora.avaliacao"))
				.paths(regex("/estudantes.*")).build().apiInfo(this.metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Avaliação Java_SVA - API REST", "API REST da Avaliação Java_SVA.", "1.0",
				"Terms of Service",
				new Contact("Elton Riva", "https://www.linkedin.com/in/elton-riva-53206739/", "notleamil@hotmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
