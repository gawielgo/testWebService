package com.itskennedy.fila4.dipendenti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itskennedy.fila4.dipendenti.dao.ProvinceDao;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceDao, Long>
{
	
}