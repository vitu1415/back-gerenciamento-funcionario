package com.ract.testreact.controller;

import java.util.List;

import com.ract.testreact.DTO.Funcionario.DadosFuncionarioPost;
import com.ract.testreact.DTO.Funcionario.DadosFuncionarioPut;
import com.ract.testreact.entity.Equipe;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ract.testreact.entity.Funcionario;
import com.ract.testreact.service.FuncionarioService;
import com.ract.testreact.service.EquipeService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	@Autowired
	private EquipeService equipeService;
	
	@GetMapping
	public List<Funcionario> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Funcionario getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> create(@RequestBody DadosFuncionarioPost dados){
		Equipe equipe = equipeService.findById(dados.equipeId());
		Funcionario funcionario = new Funcionario(null, dados.nome(), dados.email(), equipe);
		Funcionario funcionarioSalvo = service.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DadosFuncionarioPut dados) {
		Funcionario funcionario = service.findById(id);
		funcionario.atualizarInformcoes(dados);
		return ResponseEntity.ok("Funcionario atualizado :)");
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
