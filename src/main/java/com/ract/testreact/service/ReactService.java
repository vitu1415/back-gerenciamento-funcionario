  package com.ract.testreact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ract.testreact.entity.ReactEntity;
import com.ract.testreact.repository.ReactRepository;

@Service
public class ReactService {
	
	@Autowired
	private ReactRepository repository;
	
	public List<ReactEntity> findAll() {
		return repository.findAll();
	}
	
	public ReactEntity findById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	public ReactEntity save(ReactEntity te) {
		return repository.save(te);
	}
		
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
