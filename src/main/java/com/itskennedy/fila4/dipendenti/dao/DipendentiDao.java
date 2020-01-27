package com.itskennedy.fila4.dipendenti.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
}
