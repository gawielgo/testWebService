package it.corvallis.webservices.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.RegioniDao;
import it.corvallis.webservices.repository.RegioniRepository;


@Service
@Transactional
public class RegioniServiceImpl  implements RegioniService{
	
	@Autowired
	RegioniRepository regioniRepository;
	
	@Override
	public List<RegioniDao> SelTutti(){
		return regioniRepository.findAll();
	}
}