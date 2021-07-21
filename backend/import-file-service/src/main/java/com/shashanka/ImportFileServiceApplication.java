package com.shashanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImportFileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImportFileServiceApplication.class, args);
	}

}
