package com.hcl.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetDomainServiceApplication.class, args);
	}
	
}
