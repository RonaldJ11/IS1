package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.uptc.entity.Lugares;
import com.edu.uptc.repository.lugaresRepository;


@Service
public class lugaresServicesLpm  implements lugaresServices{


	@Autowired
	private lugaresRepository repository;
	
	
	
	@Override
	@Transactional(readOnly =  true)
	public Iterable<Lugares> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly =  true)
	public Page<Lugares> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =  true)
	public Optional<Lugares> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Lugares save(Lugares lugares) {
		return repository.save(lugares);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
