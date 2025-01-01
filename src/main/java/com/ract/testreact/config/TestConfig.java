package com.ract.testreact.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ract.testreact.entity.ReactEntity;
import com.ract.testreact.repository.ReactRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner, WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS em todas as rotas
                .allowedOrigins("http://localhost:3000") // Substitua pela sua origem
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*"); // Todos os cabeçalhos são permitidos
    }

	@Autowired
	private ReactRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ReactEntity re1 = new ReactEntity(null, "vitor@teste.com", "Vitor Alves");
		ReactEntity re2 = new ReactEntity(null, "joao@teste.com", "Joao");
		
		repository.saveAll(Arrays.asList(re1, re2));
	}
	
}
