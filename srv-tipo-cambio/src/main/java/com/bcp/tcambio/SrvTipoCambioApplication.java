package com.bcp.tcambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SrvTipoCambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvTipoCambioApplication.class, args);
	}

}
