package it.its.testEmployees.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployees.dao.CountriesDao;
import it.its.testEmployees.repository.CountriesRepository;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService {

	@Autowired
	CountriesRepository countriesRepository;

	@Override
	public List<CountriesDao> SelTutti() {
		return countriesRepository.findAll();
	}

}
