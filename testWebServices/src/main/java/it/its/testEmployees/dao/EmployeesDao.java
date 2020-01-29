package it.its.testEmployees.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class EmployeesDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8610876681283676856L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;

}
