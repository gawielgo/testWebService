package it.corvallis.webservices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.entities.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long>
{
	Promo findByIdPromo(String IdPromo);
	
	Promo findByAnnoAndCodice(int Anno, String Codice);
	
	@Query("SELECT DISTINCT a FROM Promo a JOIN a.dettPromo b WHERE ?1 BETWEEN b.inizio AND b.fine")
	List<Promo> SelActivePromo(Date Data);
}
