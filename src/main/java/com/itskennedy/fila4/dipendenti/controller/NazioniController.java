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
import com.itskennedy.fila4.dipendenti.dto.BaseResponseDto;
import com.itskennedy.fila4.dipendenti.dto.NazioniDto;
import com.itskennedy.fila4.dipendenti.services.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController {
	
	private static final Logger Logger = LoggerFactory.getLogger(DipendentiController.class);
	
	@Autowired
	private NazioniService nazioniService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<NazioniDto>> listAllNazioni() {
		BaseResponseDto<List<NazioniDto>> response = new BaseResponseDto<>();
		Logger.info("********** Otteniamo tutte le nazioni **********");
		
		List<NazioniDao> nazioni = nazioniService.SelTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (nazioni.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		Logger.info("Numero dei record: " + nazioni.size());
		
		NazioniDto dto = new NazioniDto();
		dto.setNazioniData(nazioni);
		
		response.setResponse(dto);
		return response;
	}
	
}
