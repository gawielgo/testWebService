package it.its.testEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployees.dao.CitiesDao;

@Repository
public interface CitiesRepository extends JpaRepository<CitiesDao, Long> {

}
