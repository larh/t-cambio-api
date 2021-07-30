package com.bcp.tcambio.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SrvEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvEurekaApplication.class, args);
	}

}
