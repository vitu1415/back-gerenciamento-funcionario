package com.ract.testreact.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ract.testreact.DTO.Equipe.DadosEquipePut;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Equipe")
@Table(name = "equipes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    private List<Funcionario> funcionarios = new ArrayList<>();


    public void atualizarInformacoes(DadosEquipePut dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (funcionarios != null) {
            funcionarios.forEach(f -> f.setEquipe(this));
        }
    }
}
