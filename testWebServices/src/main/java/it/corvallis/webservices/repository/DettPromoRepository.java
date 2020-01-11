package it.corvallis.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.corvallis.webservices.entities.DettPromo;

@Repository
public interface DettPromoRepository  extends JpaRepository<DettPromo, Long>
{
	@Query(value = "CALL Sp_SelActivePromoFid(:codFid,:codArt)", nativeQuery = true)
	DettPromo SelDettPromoByCodFid(@Param("codFid") String CodFid, @Param("codArt") String CodArt);
	
	@Modifying
	@Query(value = "UPDATE dettpromo SET OGGETTO = :oggetto WHERE ID = :id", nativeQuery = true)
	void UpdOggettoPromo(@Param("oggetto") String Oggetto, @Param("id") Long Id);
}
