package it.corvallis.webservices.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corvallis.webservices.dao.NazioniDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.NazioniDto;
import it.corvallis.webservices.service.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController 
{
	private static final Logger logger = LoggerFactory.getLogger(NazioniController.class);
	
	@Autowired
	private NazioniService NazioniService;
		
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<NazioniDto>> fetchAll()
	{
		BaseResponseDto<List<NazioniDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<NazioniDao> nazioni = NazioniService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO CORRETTO");
		
		if (nazioni.isEmpty())
		{
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + nazioni.size());
		NazioniDto dto = new NazioniDto();
		dto.setNazioniData(nazioni);
		
		response.setResponse(dto);
		
		return response;
		
	}

}