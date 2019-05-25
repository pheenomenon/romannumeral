package com.roman.adoberoman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class AdobeRomanApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("adoberoman").select()
				.apis(RequestHandlerSelectors.basePackage("com.roman.adoberoman"))
				.paths(any()).build().apiInfo(new ApiInfo("Decimal to Roman",
						"API to convert decimal to roman equivalents", "1.0.0", null,
						new Contact("Krishnadas Menon", null, null), null, null));
	}
	public static void main(String[] args) {
		SpringApplication.run(AdobeRomanApplication.class, args);
	}

}
