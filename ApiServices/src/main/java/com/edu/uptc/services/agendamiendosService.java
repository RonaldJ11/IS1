package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.uptc.entity.Agendamientos;

public interface agendamiendosService {

	public Iterable<Agendamientos> findAll();
	public Page<Agendamientos> findAll(Pageable pageable);
	public Optional<Agendamientos> findById(Integer id);
	public Agendamientos save(Agendamientos agendamiento);
	public void deleteById(Integer id);
	
	
}
