package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.entities.Articoli;

@Repository
public interface ArticoliRepository extends JpaRepository<Articoli, Long>
{
	
}
