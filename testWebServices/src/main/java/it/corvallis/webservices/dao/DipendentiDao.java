package it.corvallis.webservices.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data

public class DipendentiDao implements Serializable{

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "telefono")
	private String telefono;
	
}
