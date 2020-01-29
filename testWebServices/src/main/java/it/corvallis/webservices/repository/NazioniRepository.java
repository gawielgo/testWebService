package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.NazioniDao;

@Repository
public interface NazioniRepository extends JpaRepository<NazioniDao, Long>
{
	
}