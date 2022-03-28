package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.uptc.entity.Agendamientos;
import com.edu.uptc.repository.agendamientosRepository;


@Service
public class agendamientosServiceLpm implements agendamiendosService{

	@Autowired
	private agendamientosRepository repository;
	
	
	@Override
	@Transactional(readOnly =  true)
	public Iterable<Agendamientos> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly =  true)
	public Page<Agendamientos> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =  true)
	public Optional<Agendamientos> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Agendamientos save(Agendamientos agendamiento) {
		return repository.save(agendamiento);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
