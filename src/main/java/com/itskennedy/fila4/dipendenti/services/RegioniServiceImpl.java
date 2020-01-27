package com.itskennedy.fila4.dipendenti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itskennedy.fila4.dipendenti.dao.RegioniDao;
import com.itskennedy.fila4.dipendenti.repository.RegioniRepository;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService {
	
	@Autowired
	RegioniRepository regioniRepository;
	
	@Override
	public List<RegioniDao> SelTutti() {
		return regioniRepository.findAll();
	}
}
