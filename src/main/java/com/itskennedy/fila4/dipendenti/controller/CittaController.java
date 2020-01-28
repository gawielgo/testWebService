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

import com.itskennedy.fila4.dipendenti.dao.CittaDao;
import com.itskennedy.fila4.dipendenti.dto.BaseResponseDto;
import com.itskennedy.fila4.dipendenti.dto.CittaDto;
import com.itskennedy.fila4.dipendenti.services.CittaService;

@RestController
@RequestMapping(value = "api/citta")
public class CittaController {
	
	private static final Logger Logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	private CittaService cittaService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CittaDto>> listAllCitta() {
		BaseResponseDto<List<CittaDto>> response = new BaseResponseDto<>();
		Logger.info("********** Otteniamo tutte le città **********");
		
		List<CittaDao> citta = cittaService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (citta.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		Logger.info("Numero dei record: " + citta.size());
		
		CittaDto dto = new CittaDto();
		dto.setCittaData(citta);
		
		response.setResponse(dto);
		return response;
	}
	
}
