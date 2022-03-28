package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.uptc.entity.Servicios;
import com.edu.uptc.repository.serviceRepository;


@Service
public class serviceServicesLpm implements serviceServices{


	@Autowired
	private serviceRepository repository;
	
	
	
	@Override
	@Transactional(readOnly =  true)
	public Iterable<Servicios> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly =  true)
	public Page<Servicios> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =  true)
	public Optional<Servicios> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Servicios save(Servicios servicios) {
		return repository.save(servicios);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
