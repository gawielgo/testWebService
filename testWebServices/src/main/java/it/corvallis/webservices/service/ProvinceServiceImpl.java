package it.corvallis.webservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.ProvinceDao;
import it.corvallis.webservices.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public List<ProvinceDao> SelProv() {
		return provinceRepository.findAll();
	}

}
