package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.uptc.entity.Clientes;

public interface clientesService {

	public Iterable<Clientes> findAll();
	public Page<Clientes> findAll(Pageable pageable);
	public Optional<Clientes> findById(Integer id);
	public Clientes save(Clientes cliente);
	public void deleteById(Integer id);
}
