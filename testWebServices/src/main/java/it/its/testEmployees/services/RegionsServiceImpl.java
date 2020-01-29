package it.its.testEmployees.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.testEmployees.dao.RegionsDao;
import it.its.testEmployees.repository.RegionsRepository;

@Service
@Transactional
public class RegionsServiceImpl implements RegionsService {

	@Autowired
	RegionsRepository regionRepository;

	@Override
	public List<RegionsDao> SelTutti() {
		// TODO Auto-generated method stub
		return regionRepository.findAll();
	}

}
