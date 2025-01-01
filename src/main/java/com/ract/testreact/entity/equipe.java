package com.ract.testreact.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_equipe")
public class equipe {
	
	private Long id;
	private String nameEquipe;
}
