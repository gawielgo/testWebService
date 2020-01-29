package it.its.testEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployees.dao.CountriesDao;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesDao, Long> {

}
