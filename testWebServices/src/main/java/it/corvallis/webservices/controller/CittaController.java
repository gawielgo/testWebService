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

import it.corvallis.webservices.dao.CittaDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.CittaDto;
import it.corvallis.webservices.service.CittaService;

@RestController
@RequestMapping(value = "api/citta")
public class CittaController 
{
	private static final Logger logger = LoggerFactory.getLogger(CittaController.class);
	
	@Autowired
	private CittaService CittaService;
		
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CittaDto>> fetchAll()
	{
		BaseResponseDto<List<CittaDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<CittaDao> citta = CittaService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO CORRETTO");
		
		if (citta.isEmpty())
		{
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + citta.size());
		CittaDto dto = new CittaDto();
		dto.setCittaData(citta);
		
		response.setResponse(dto);
		
		return response;
		
	}

}