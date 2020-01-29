package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.dao.RegioniDao;

@Repository
public interface RegioniRepository extends JpaRepository<RegioniDao, Long>{

}
