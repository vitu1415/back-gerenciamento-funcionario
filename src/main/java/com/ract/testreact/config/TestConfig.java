package com.ract.testreact.config;

import java.util.ArrayList;
import java.util.Arrays;

import com.ract.testreact.entity.Equipe;
import com.ract.testreact.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ract.testreact.entity.Funcionario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner, WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS em todas as rotas
                .allowedOrigins("https://listsfuncionario.vercel.app") // Substitua pela sua origem
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*"); // Todos os cabeçalhos são permitidos
    }

	@Autowired
	private com.ract.testreact.repository.FuncionarioRepository FuncionarioRepository;
	@Autowired
	private EquipeRepository EquipeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Equipe equipe1 = new Equipe(null, "flash", "melhor equipe", new ArrayList<>());
		equipe1 = EquipeRepository.save(equipe1);
		Funcionario re1 = new Funcionario(null, "Vitor Alves", "vitor@teste.com", equipe1);
		Funcionario re2 = new Funcionario(null, "Joao", "joao@teste.com", equipe1);

		FuncionarioRepository.saveAll(Arrays.asList(re1, re2));
	}
	
}
