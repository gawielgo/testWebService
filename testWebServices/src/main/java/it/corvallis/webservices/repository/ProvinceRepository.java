package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.ProvinceDao;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceDao, Long>{

}
