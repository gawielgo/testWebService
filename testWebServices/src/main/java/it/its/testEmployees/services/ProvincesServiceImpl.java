package it.its.testEmployees.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployees.dao.ProvincesDao;
import it.its.testEmployees.repository.ProvincesRepository;

@Service
@Transactional
public class ProvincesServiceImpl implements ProvincesService {

	@Autowired
	ProvincesRepository provincesRepository;

	@Override
	public List<ProvincesDao> SelTutti() {
		return provincesRepository.findAll();
	}

}
