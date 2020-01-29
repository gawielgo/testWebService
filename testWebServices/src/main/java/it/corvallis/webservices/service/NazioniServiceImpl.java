package it.corvallis.webservices.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.NazioniDao;
import it.corvallis.webservices.repository.NazioniRepository;


@Service
@Transactional
public class NazioniServiceImpl  implements NazioniService{
	
	@Autowired
	NazioniRepository nazioniRepository;
	
	@Override
	public List<NazioniDao> SelTutti(){
		return nazioniRepository.findAll();
	}
}
