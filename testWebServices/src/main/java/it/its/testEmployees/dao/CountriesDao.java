package it.its.testEmployees.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class CountriesDao {

	@Id
	@Column(name = "ISO")
	private String iso;

	@Column(name = "description")
	private String description;

}
