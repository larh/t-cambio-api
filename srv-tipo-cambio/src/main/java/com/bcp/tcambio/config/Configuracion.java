package com.bcp.tcambio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configuracion {

private String pathTarifario = "http://tcambio-srv-tarifario:8085/tarifario";
	
	@Bean
	WebClient webClient() {
		return WebClient.builder().baseUrl(pathTarifario).build();
	}
}
