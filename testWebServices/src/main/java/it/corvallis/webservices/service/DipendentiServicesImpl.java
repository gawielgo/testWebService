package it.corvallis.webservices.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.dao.DipendentiDao;
import it.corvallis.webservices.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServicesImpl  implements DipendentiServices{
	
	@Autowired
	DipendentiRepository dipendentiRepository;
	
	@Override
	public List<DipendentiDao> SelTutti(){
		return dipendentiRepository.findAll();
	}
}
