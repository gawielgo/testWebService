package it.its.testEmployees.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class CitiesDao {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "description")
	private String description;

	@Column(name = "ID_province")
	private String idProvince;

}
