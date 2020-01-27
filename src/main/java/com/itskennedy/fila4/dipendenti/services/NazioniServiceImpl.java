package com.itskennedy.fila4.dipendenti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itskennedy.fila4.dipendenti.dao.NazioniDao;
import com.itskennedy.fila4.dipendenti.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService {
	
	@Autowired
	NazioniRepository nazioniRepository;
	
	@Override
	public List<NazioniDao> SelTutti() {
		return nazioniRepository.findAll();
	}
}
