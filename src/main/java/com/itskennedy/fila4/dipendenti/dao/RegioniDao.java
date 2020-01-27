package com.itskennedy.fila4.dipendenti.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regioni")
@Data
public class RegioniDao {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	//@ManyToOne // più regioni hanno una nazione. Si usa Hibernate.
	@Column(name = "iso_nazione")
	private String isoNazione;
}
