package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.DipendentiDao;

@Repository
public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long>
{
	
}