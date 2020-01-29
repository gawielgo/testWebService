package it.corvallis.webservices.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "province")
@Data

public class ProvinceDao implements Serializable{

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
}
