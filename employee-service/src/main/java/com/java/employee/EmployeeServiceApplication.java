package com.java.employee;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
//@EnableCircuitBreaker
@EnableEurekaClient
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {
	
		return new ApiInfo("My REST API", "Some custom description of API.", "API TOS", "Terms of service",
				new Contact("http://localhost:8081/member/Api/", "", "m04.venisiya@gmail.com"), "", "",
				Collections.emptyList());
	}


}
