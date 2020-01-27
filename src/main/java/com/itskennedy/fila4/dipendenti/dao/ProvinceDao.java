package com.itskennedy.fila4.dipendenti.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "province")
@Data
public class ProvinceDao {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "id_regione")
	private int idRegione;
}
