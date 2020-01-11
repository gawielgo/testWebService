package it.corvallis.webservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.corvallis.webservices.entities.DettPromo;
import it.corvallis.webservices.service.DettPromoService;

@RestController
@RequestMapping(value = "api/dettpromo")
public class DettPromoController 
{
	private static final Logger logger = LoggerFactory.getLogger(DettPromoController.class);
	
	@Autowired
	DettPromoService dettPromoService;
	
	@GetMapping(value = "/{idFidelity}/{codArt}", produces = "application/json")
	public ResponseEntity<DettPromo> listDettPromoByCodFid(@PathVariable("idFidelity") String IdFidelity,
			@PathVariable("codArt") String CodArt)
	{
		logger.info("****** Otteniamo le promozioni della Fidelity: " + IdFidelity + "*******");
		
		DettPromo dettPromo = dettPromoService.SelDettPromoByCodFid(IdFidelity, CodArt);
		
		if (dettPromo == null)
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<DettPromo>(dettPromo, HttpStatus.OK);
	}
	
	@PutMapping(value = "/modifica")
	public ResponseEntity<?> updateDettPromo(@RequestParam("id") Long Id, @RequestParam("oggetto") String Oggetto)
	{
		logger.info("Modifichiamo il dettaglio promo " + Id);

		dettPromoService.UpdOggettoPromo(Oggetto, Id);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
