package it.its.testEmployees.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regions")
@Data
public class RegionsDao {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "description")
	private String description;

	@Column(name = "ISO_country")
	private String isoCountry;

}
