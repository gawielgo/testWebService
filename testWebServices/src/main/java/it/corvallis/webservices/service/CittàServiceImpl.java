package it.corvallis.webservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.CittàDao;
import it.corvallis.webservices.repository.CittàRepository;

@Service
@Transactional
public class CittàServiceImpl implements CittàService{

	@Autowired
	CittàRepository cittàRepository;
	
	@Override
	public List<CittàDao> SelCit() {
		return cittàRepository.findAll();
	}

}
