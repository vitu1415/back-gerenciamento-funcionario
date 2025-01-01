package com.ract.testreact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ract.testreact.entity.ReactEntity;
import com.ract.testreact.service.ReactService;

@RestController
@RequestMapping("/funcionario")
public class ReactController {
	
	@Autowired
	private ReactService service;
	
	@GetMapping
	public List<ReactEntity> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ReactEntity getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ReactEntity create(@RequestBody ReactEntity re){
		return service.save(re);
	}
	
	@PutMapping("/{id}")
	public ReactEntity update(@PathVariable Long id, @RequestBody ReactEntity re) {
		re.setId(id);
		return service.save(re);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
