package com.paypall.paymentinformation.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class PaymentInformationConfiguration {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/v1/api/payment/*/*"))
				.apis(RequestHandlerSelectors.basePackage("com.paypall.paymentinformation")).build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		ApiInfo apiInfo = new ApiInfo("Payment Details API", "Get Customer Payment Details", "1.0", "Terms of Services",
				new Contact("Giridhar K", "", ""), "API Licence", "Licence URL", Collections.emptyList());
		return apiInfo;
	}

}
