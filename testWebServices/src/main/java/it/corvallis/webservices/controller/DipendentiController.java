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

import it.corvallis.webservices.dao.DipendentiDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.DipendentiDto;
import it.corvallis.webservices.service.DipendentiService;

@RestController
@RequestMapping(value = "api/dipendenti")
public class DipendentiController {
	
	private static final Logger logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	DipendentiService dipendentiService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> fetchAll()
	{
		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<DipendentiDao> dipendenti = dipendentiService.SelDip();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record:" + dipendenti.size());
		
		DipendentiDto dto = new DipendentiDto();
		dto.setDipendentiData(dipendenti);
		
		response.setResponse(dto);
		
		return response;
	}
	
}
