package it.corvallis.webservices.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regioni")
@Data

public class RegioniDao implements Serializable{

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
}
