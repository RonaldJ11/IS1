package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.uptc.entity.Prestadores;

public interface prestadoresServices {
	public Iterable<Prestadores> findAll();
	public Page<Prestadores> findAll(Pageable pageable);
	public Optional<Prestadores> findById(Integer id);
	public Prestadores save(Prestadores prestador);
	public void deleteById(Integer id);
}
