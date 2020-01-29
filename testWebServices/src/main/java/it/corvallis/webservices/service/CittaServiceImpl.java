package it.corvallis.webservices.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.CittaDao;
import it.corvallis.webservices.repository.CittaRepository;


@Service
@Transactional
public class CittaServiceImpl  implements CittaService{
	
	@Autowired
	CittaRepository cittaRepository;
	
	@Override
	public List<CittaDao> SelTutti(){
		return cittaRepository.findAll();
	}
}
