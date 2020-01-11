package it.corvallis.webservices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "articoli")
@Data
public class Articoli  implements Serializable
{
	private static final long serialVersionUID = -2077445225617424877L;

	@Id
	@Column(name = "CODART")
	private String codArt;
	
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	

}
