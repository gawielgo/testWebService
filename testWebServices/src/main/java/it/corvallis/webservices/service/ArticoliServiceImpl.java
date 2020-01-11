package it.corvallis.webservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corvallis.webservices.entities.Articoli;
import it.corvallis.webservices.repository.ArticoliRepository;

@Service
@Transactional
public class ArticoliServiceImpl implements ArticoliService
{
	@Autowired
	ArticoliRepository articoliRepository;

	@Override
	public List<Articoli> SelTutti() 
	{
		return articoliRepository.findAll();
	}

}
