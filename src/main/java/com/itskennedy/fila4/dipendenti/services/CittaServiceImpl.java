package com.itskennedy.fila4.dipendenti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itskennedy.fila4.dipendenti.dao.CittaDao;
import com.itskennedy.fila4.dipendenti.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService {
	
	@Autowired
	CittaRepository cittaRepository;
	
	@Override
	public List<CittaDao> SelTutti() {
		return cittaRepository.findAll();
	}
}
