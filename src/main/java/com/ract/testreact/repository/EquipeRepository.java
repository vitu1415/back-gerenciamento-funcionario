package com.ract.testreact.repository;

import com.ract.testreact.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    List<Equipe> findByUserToken(String userToken);
}
