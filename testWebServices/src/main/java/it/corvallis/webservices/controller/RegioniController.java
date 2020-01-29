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

import it.corvallis.webservices.dao.RegioniDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.RegioniDto;
import it.corvallis.webservices.service.RegioniService;

@RestController
@RequestMapping(value = "api/regioni")
public class RegioniController {

private static final Logger logger = LoggerFactory.getLogger(RegioniController.class);
	
	@Autowired
	RegioniService regioniService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<RegioniDto>> fetchAll()
	{
		BaseResponseDto<List<RegioniDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<RegioniDao> regioni = regioniService.SelReg();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (regioni.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record:" + regioni.size());
		
		RegioniDto dto = new RegioniDto();
		dto.setRegioniData(regioni);
		
		response.setResponse(dto);
		
		return response;
	}
	
}
