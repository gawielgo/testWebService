package it.its.testEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.its.testEmployees.dao.RegionsDao;

@Repository
public interface RegionsRepository extends JpaRepository<RegionsDao, Long> {

}
