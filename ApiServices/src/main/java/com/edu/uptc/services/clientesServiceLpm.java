package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.uptc.entity.Clientes;
import com.edu.uptc.repository.clientesRepository;


@Service
public class clientesServiceLpm implements clientesService{

	@Autowired
	private clientesRepository repository;
	
	
	
	@Override
	@Transactional(readOnly =  true)
	public Iterable<Clientes> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly =  true)
	public Page<Clientes> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =  true)
	public Optional<Clientes> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Clientes save(Clientes clientes) {
		return repository.save(clientes);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
