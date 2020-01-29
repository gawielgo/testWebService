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

import it.corvallis.webservices.dao.CittàDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.CittàDto;
import it.corvallis.webservices.service.CittàService;

@RestController
@RequestMapping(value = "api/città")
public class CittàController {
	
private static final Logger logger = LoggerFactory.getLogger(CittàController.class);
	
	@Autowired
	CittàService cittàService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CittàDto>> fetchAll()
	{
		BaseResponseDto<List<CittàDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<CittàDao> città = cittàService.SelCit();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (città.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record:" + città.size());
		
		CittàDto dto = new CittàDto();
		dto.setCittàData(città);
		
		response.setResponse(dto);
		
		return response;
	}
	
}
