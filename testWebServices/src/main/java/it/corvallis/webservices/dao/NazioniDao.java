package it.corvallis.webservices.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="nazioni")
@Data
public class NazioniDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "iso")
	private Long iso;
	
	@Column(name = "descrizione")
	private String descrizione;
	
}