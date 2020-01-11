package it.corvallis.webservices.service;
import java.util.Date;
import java.util.List;

import it.corvallis.webservices.entities.Promo;

public interface PromoService 
{
	public List<Promo> SelTutti();
	
	public Promo SelByIdPromo(String IdPromo);
	
	public Promo SelByAnnoCodice(String Anno, String Codice);
	
	List<Promo> SelActivePromo(Date Data);
	
	public void InsPromo(Promo promo);
	
	public void DelPromo(Promo promo);
}
