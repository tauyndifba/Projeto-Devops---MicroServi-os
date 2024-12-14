package com.ifba.tauynd.projeto_devops_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjetoDevopsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDevopsAppApplication.class, args);
	}

	@Configuration
	public class AppConfig {
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

	}
}
