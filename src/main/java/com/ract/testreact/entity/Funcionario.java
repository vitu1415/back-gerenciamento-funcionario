package com.ract.testreact.entity;

import java.io.Serializable;

import com.ract.testreact.DTO.Funcionario.DadosFuncionarioPut;
import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;

	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;

	public void atualizarInformcoes(DadosFuncionarioPut dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.email() != null) {
			this.email = dados.email();
		}
	}
}