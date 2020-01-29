package it.its.testEmployees.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "provinces")
@Data
public class ProvincesDao {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "description")
	private String description;

	@Column(name = "ID_region")
	private String idRegion;

}
