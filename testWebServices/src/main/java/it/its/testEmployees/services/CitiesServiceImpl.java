package it.its.testEmployees.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployees.dao.CitiesDao;
import it.its.testEmployees.repository.CitiesRepository;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService {

	@Autowired
	CitiesRepository citiesRepository;

	@Override
	public List<CitiesDao> SelTutti() {
		return citiesRepository.findAll();
	}

}
