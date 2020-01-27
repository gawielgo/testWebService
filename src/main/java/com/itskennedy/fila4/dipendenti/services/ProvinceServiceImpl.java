package com.itskennedy.fila4.dipendenti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itskennedy.fila4.dipendenti.dao.ProvinceDao;
import com.itskennedy.fila4.dipendenti.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public List<ProvinceDao> SelTutti() {
		return provinceRepository.findAll();
	}
}
