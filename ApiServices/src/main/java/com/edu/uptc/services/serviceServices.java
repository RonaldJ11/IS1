package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.uptc.entity.Servicios;

public interface serviceServices {
	public Iterable<Servicios> findAll();
	public Page<Servicios> findAll(Pageable pageable);
	public Optional<Servicios> findById(Integer id);
	public Servicios save(Servicios Servicio);
	public void deleteById(Integer id);
}
