package it.its.testEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployees.dao.ProvincesDao;

@Repository
public interface ProvincesRepository extends JpaRepository<ProvincesDao, Long> {

}
