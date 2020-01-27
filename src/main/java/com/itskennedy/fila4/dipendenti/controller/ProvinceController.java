package com.itskennedy.fila4.dipendenti.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itskennedy.fila4.dipendenti.dao.NazioniDao;
import com.itskennedy.fila4.dipendenti.dao.ProvinceDao;
import com.itskennedy.fila4.dipendenti.dto.BaseResponseDto;
import com.itskennedy.fila4.dipendenti.dto.NazioniDto;
import com.itskennedy.fila4.dipendenti.dto.ProvinceDto;
import com.itskennedy.fila4.dipendenti.services.NazioniService;
import com.itskennedy.fila4.dipendenti.services.ProvinceService;

@RestController
@RequestMapping(value = "api/province")
public class ProvinceController {
	
	private static final Logger Logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ProvinceDto>> listAllProvince() {
		BaseResponseDto<List<ProvinceDto>> response = new BaseResponseDto<>();
		Logger.info("********** Otteniamo tutte le province **********");
		
		List<ProvinceDao> province = provinceService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (province.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		Logger.info("Numero dei record: " + province.size());
		
		ProvinceDto dto = new ProvinceDto();
		dto.setProvinceData(province);
		
		response.setResponse(dto);
		return response;
	}
	
}
