package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.CittaDao;

@Repository
public interface CittaRepository extends JpaRepository<CittaDao, Long>
{
	
}