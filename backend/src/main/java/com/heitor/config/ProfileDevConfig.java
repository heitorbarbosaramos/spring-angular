package com.heitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Profile("dev")
@Slf4j
public class ProfileDevConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strateg;
	
	@Autowired
	private DBInstancia db;

	@Bean
	public Boolean instantiateDataBase() {
		
		log.info("PERFIL TESTE CARREGADO");
		log.info("ESTRATEGIA BANCO: " + strateg);
		if (strateg.equals("create")) {
			db.addTarefa();
		}
		
		
		return true;
	}

}
