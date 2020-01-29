package it.its.testEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployees.dao.EmployeesDao;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesDao, Long> {

}
