package it.corvallis.webservices.service;

import it.corvallis.webservices.entities.DettPromo;

public interface DettPromoService 
{
	DettPromo SelDettPromoByCodFid(String CodFid, String CodArt);
	
	void UpdOggettoPromo(String Oggetto, Long Id);
}
