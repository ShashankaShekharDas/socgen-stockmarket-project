package com.shashanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SectorDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SectorDetailServiceApplication.class, args);
	}

}
