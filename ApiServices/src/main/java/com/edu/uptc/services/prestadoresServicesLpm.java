package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.uptc.entity.Prestadores;
import com.edu.uptc.repository.prestadoresRepository;


@Service
public class prestadoresServicesLpm implements prestadoresServices{

	@Autowired
	private prestadoresRepository repository;
	
	
	
	@Override
	@Transactional(readOnly =  true)
	public Iterable<Prestadores> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly =  true)
	public Page<Prestadores> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =  true)
	public Optional<Prestadores> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Prestadores save(Prestadores prestadores) {
		return repository.save(prestadores);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
