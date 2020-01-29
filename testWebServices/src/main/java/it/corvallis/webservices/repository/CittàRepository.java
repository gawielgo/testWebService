package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.CittàDao;

@Repository
public interface CittàRepository extends JpaRepository<CittàDao, Long>{

}
