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

import it.corvallis.webservices.dao.ProvinceDao;
import it.corvallis.webservices.dto.BaseResponseDto;
import it.corvallis.webservices.dto.ProvinceDto;
import it.corvallis.webservices.service.ProvinceService;

@RestController
@RequestMapping(value = "api/province")
public class ProvinceController 
{
	private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);
	
	@Autowired
	private ProvinceService ProvinceService;
		
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ProvinceDto>> fetchAll()
	{
		BaseResponseDto<List<ProvinceDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<ProvinceDao> province = ProvinceService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO CORRETTO");
		
		if (province.isEmpty())
		{
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + province.size());
		ProvinceDto dto = new ProvinceDto();
		dto.setProvinceData(province);
		
		response.setResponse(dto);
		
		return response;
		
	}

}