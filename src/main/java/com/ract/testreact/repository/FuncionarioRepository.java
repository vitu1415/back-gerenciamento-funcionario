package com.ract.testreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ract.testreact.entity.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    List<Funcionario> findByUserToken(String userToken);
}