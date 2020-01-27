package com.itskennedy.fila4.dipendenti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itskennedy.fila4.dipendenti.dao.DipendentiDao;
import com.itskennedy.fila4.dipendenti.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService {
	
	@Autowired
	DipendentiRepository dipendentiRepository;
	
	@Override
	public List<DipendentiDao> SelTutti() {
		return dipendentiRepository.findAll();
	}
}
