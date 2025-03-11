package com.ract.testreact.DTO.Equipe;

import java.util.List;

public record DadosEquipePut(

        String nome,
        String descricao,
        List<Long> funcionarioIds) {
}
