  package com.ract.testreact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ract.testreact.entity.Funcionario;
import com.ract.testreact.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll() {
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	public Funcionario save(Funcionario te) {
		return repository.save(te);
	}
		
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
