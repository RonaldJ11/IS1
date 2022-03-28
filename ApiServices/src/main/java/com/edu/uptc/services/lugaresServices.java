package com.edu.uptc.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.uptc.entity.Lugares;

public interface lugaresServices {
	public Iterable<Lugares> findAll();
	public Page<Lugares> findAll(Pageable pageable);
	public Optional<Lugares> findById(Integer id);
	public Lugares save(Lugares lugare);
	public void deleteById(Integer id);
}
