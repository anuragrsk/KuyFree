package com.kuyfree.app.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class EnableSwagger {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.kuyfree.app.rest")).paths(regex("/api.*")).build()
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		@SuppressWarnings("rawtypes")
		ArrayList<VendorExtension> array = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("KuyFree", "KuyFree API", "1.0", "Terms of service",
				new Contact("Anurag Sharma", "http://localhost:8080", "anurag_s@outlook.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", array);
		return apiInfo;
	}

}
