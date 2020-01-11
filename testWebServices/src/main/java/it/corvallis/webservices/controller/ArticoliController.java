package it.corvallis.webservices.controller;

 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corvallis.webservices.entities.Articoli;
import it.corvallis.webservices.service.ArticoliService;

@RestController
@RequestMapping(value = "api/articoli")
public class ArticoliController 
{
	private static final Logger logger = LoggerFactory.getLogger(ArticoliController.class);
	
	@Autowired
	private ArticoliService articoliService;
		
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Articoli>> listAllPromo()
	{
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<Articoli> articoli = articoliService.SelTutti();
		
		if (articoli.isEmpty())
		{
			return new ResponseEntity<List<Articoli>>(HttpStatus.NO_CONTENT);
		}
		
		logger.info("Numero dei record: " + articoli.size());
		
		return new ResponseEntity<List<Articoli>>(articoli, HttpStatus.OK);
		
	}

}
