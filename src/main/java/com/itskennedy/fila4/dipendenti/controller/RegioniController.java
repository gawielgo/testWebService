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

import com.itskennedy.fila4.dipendenti.dao.RegioniDao;
import com.itskennedy.fila4.dipendenti.dto.BaseResponseDto;
import com.itskennedy.fila4.dipendenti.dto.RegioniDto;
import com.itskennedy.fila4.dipendenti.services.RegioniService;

@RestController
@RequestMapping(value = "api/regioni")
public class RegioniController {
	
	private static final Logger Logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	private RegioniService regioniService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<RegioniDto>> listAllRegioni() {
		BaseResponseDto<List<RegioniDto>> response = new BaseResponseDto<>();
		Logger.info("********** Otteniamo tutte le regioni **********");
		
		List<RegioniDao> regioni = regioniService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (regioni.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		Logger.info("Numero dei record: " + regioni.size());
		
		RegioniDto dto = new RegioniDto();
		dto.setRegioniData(regioni);
		
		response.setResponse(dto);
		return response;
	}
	
}
