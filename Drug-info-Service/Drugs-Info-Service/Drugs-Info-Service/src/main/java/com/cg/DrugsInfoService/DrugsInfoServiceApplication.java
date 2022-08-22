package com.cg.DrugsInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class DrugsInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugsInfoServiceApplication.class, args);
	}

}
