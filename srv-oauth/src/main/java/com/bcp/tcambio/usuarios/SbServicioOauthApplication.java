package com.bcp.tcambio.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class SbServicioOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SbServicioOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		for(int i=0; i<4; i++) {
			System.out.println(passwordEncoder.encode(password));
		}
	}

}
