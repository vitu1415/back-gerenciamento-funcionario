package com.ract.testreact.controller;

import com.ract.testreact.entity.Equipe;
import com.ract.testreact.DTO.Equipe.DadosEquipePost;
import com.ract.testreact.DTO.Equipe.DadosEquipePut;
import com.ract.testreact.service.EquipeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("equipes")
public class EquipeController {

    @Autowired
    private EquipeService service;

    @PostMapping
    public ResponseEntity<Equipe> create(@RequestBody DadosEquipePost dados, @RequestHeader("User-Token") String userToken) {
        Equipe equipe = new Equipe(null, dados.nome(), dados.descricao(), new ArrayList<>(), userToken);
        Equipe equipeSalva = service.save(equipe);
        return ResponseEntity.ok(equipeSalva);
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> getAll(@RequestHeader("User-Token") String userToken) {
        if (userToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<Equipe> equipe = service.findByUserToken(userToken);
        return ResponseEntity.ok(equipe);
    }

    @GetMapping("/{id}")
    public Equipe getById(@PathVariable Long id, @RequestHeader("User-Token") String userToken){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DadosEquipePut dados, @RequestHeader("User-Token") String userToken) {
        var equipe = service.findById(id);

        equipe.atualizarInformacoes(dados);

        return ResponseEntity.ok("Equipe atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestHeader("User-Token") String userToken) { service.deleteById(id);}
}