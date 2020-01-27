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

import com.itskennedy.fila4.dipendenti.dao.DipendentiDao;
import com.itskennedy.fila4.dipendenti.dto.BaseResponseDto;
import com.itskennedy.fila4.dipendenti.dto.DipendentiDto;
import com.itskennedy.fila4.dipendenti.services.DipendentiService;

@RestController
@RequestMapping(value = "api/dipendenti")
public class DipendentiController {

	private static final Logger Logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	private DipendentiService dipendentiService;
		
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> listAllDipendenti() {
		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		Logger.info("********** Otteniamo tutti i dipendenti **********");
		
		List<DipendentiDao> dipendenti = dipendentiService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		Logger.info("Numero dei record: " + dipendenti.size());
		
		DipendentiDto dto = new DipendentiDto();
		dto.setDipendentiData(dipendenti);
		
		response.setResponse(dto);
		return response;
	}
}
