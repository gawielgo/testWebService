package it.corvallis.webservices.controller;

 
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corvallis.webservices.entities.Promo;
import it.corvallis.webservices.exception.PromoNotFoundException;
import it.corvallis.webservices.service.PromoService;

@RestController
@RequestMapping(value = "api/promo")
public class PromoController 
{
	private static final Logger logger = LoggerFactory.getLogger(PromoController.class);
	
	@Autowired
	private PromoService promoService;
		
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Promo>> listAllPromo()
	{
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<Promo> promo = promoService.SelTutti();
		
		if (promo.isEmpty())
		{
			return new ResponseEntity<List<Promo>>(HttpStatus.NO_CONTENT);
		}
		
		logger.info("Numero dei record: " + promo.size());
		
		return new ResponseEntity<List<Promo>>(promo, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/id/{idPromo}", produces = "application/json")
	public ResponseEntity<Promo> listPromoById(@PathVariable("idPromo") String IdPromo) 
			 throws PromoNotFoundException
	{
		logger.info("****** Otteniamo la promozione con Id: " + IdPromo + "*******");
		
		Promo promo = promoService.SelByIdPromo(IdPromo);
		
		if (promo == null)
		{
			throw new PromoNotFoundException("Promozione Assente o Id Errato");
			//return new ResponseEntity<Promo>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Promo>(promo, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/codice", produces = "application/json")
	public ResponseEntity<Promo> listPromoByCodice(@RequestParam("anno") String Anno,
			@RequestParam("codice") String Codice) 
	{
		logger.info("****** Otteniamo la promozione con Codice: " + Codice + "*******");
		
		Promo promo = promoService.SelByAnnoCodice(Anno, Codice);
		
		if (promo == null)
		{
			return new ResponseEntity<Promo>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Promo>(promo, HttpStatus.OK);
	}
	
	@GetMapping(value = "/active", produces = "application/json")
	public ResponseEntity<List<Promo>> listPromoActive()
	{
		logger.info("****** Otteniamo la Promozione Attive*******");
		
		Date today = new Date();
		List<Promo> promo = promoService.SelActivePromo(today);
		
		if (promo == null)
		{
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Promo>>(promo, HttpStatus.OK);
	}
	
	@PostMapping(value = "/inserisci")
	public ResponseEntity<Promo> createPromo(@RequestBody Promo promo)
	{
		if (promo.getIdPromo().length() == 0)
		{
			UUID uuid = UUID.randomUUID();
		    String GUID = uuid.toString();
		    
		    logger.info("***** Creiamo una Promo con id " + GUID + " *****");
		    
		    promo.setIdPromo(GUID);
		}
		else
		{
			 logger.warn("Impossibile modificare con il metodo POST ");
			 
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			 
			
		}
		
		promoService.InsPromo(promo);
		
		return new ResponseEntity<Promo>(new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/modifica")
	public ResponseEntity<Promo> updatePromo(@RequestBody Promo promo)
	{
		 logger.info("***** Modifichiamo la Promo con id " + promo.getIdPromo() + " *****");
		 
		 if (promo.getIdPromo().length() > 0)
		 {
			 promoService.InsPromo(promo);
			 
			 return new ResponseEntity<Promo>(new HttpHeaders(), HttpStatus.CREATED);
		 }
		 else
		 {
			 logger.warn("Impossibile modificare una promozione priva di id! ");
			 
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
	}
	
	@DeleteMapping(value = "/elimina/{idPromo}")
	public ResponseEntity<?> deletePromo(@PathVariable("idPromo") String IdPromo) 
	{
		logger.info("Eliminiamo la promo con id " + IdPromo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		Promo promo = promoService.SelByIdPromo(IdPromo);
		
		if (promo == null)
		{
			logger.warn("Impossibile trovare la promo con id " + IdPromo);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		promoService.DelPromo(promo);
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Promozione " + IdPromo + " Eseguita Con Successo!");
		
		return new ResponseEntity<>(responseNode, headers, HttpStatus.OK);
	}
	
	
}
