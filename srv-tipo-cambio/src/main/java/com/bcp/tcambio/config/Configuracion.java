package com.bcp.tcambio.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {

	private String pathTarifario = "http://localhost:8080/tarifario";
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder().rootUri(pathTarifario).build();
	}
}
