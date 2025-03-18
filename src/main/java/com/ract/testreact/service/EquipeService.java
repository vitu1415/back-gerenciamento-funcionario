package com.ract.testreact.service;

import com.ract.testreact.entity.Equipe;
import com.ract.testreact.repository.EquipeRepository;
import com.ract.testreact.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Equipe> findAll() {return repository.findAll();}

    public Equipe findById(Long id) {return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe não encontrada"));}

    public Equipe save(Equipe equipe) {return repository.save(equipe);}

    public void deleteById(Long id) {
        Equipe equipe = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe nao encontrada"));
        if(!equipe.getFuncionarios().isEmpty()) {
            funcionarioRepository.deleteAll(equipe.getFuncionarios());
        }
        repository.delete(equipe);
    }

    public List<Equipe> findByUserToken(String userToken) {
        return repository.findByUserToken(userToken);
    }
}