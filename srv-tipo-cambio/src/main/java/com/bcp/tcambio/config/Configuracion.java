package com.bcp.tcambio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configuracion {

private String pathTarifario = "http://localhost:8080/tarifario";
	
	@Bean
	WebClient webClient() {
		return WebClient.builder().baseUrl(pathTarifario).build();
	}
}
