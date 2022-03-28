package com.edu.uptc.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uptc.entity.Prestadores;
import com.edu.uptc.services.prestadoresServices;



@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })

@RequestMapping("/api/prestadores")
public class prestadoresController {
	@Autowired
	private prestadoresServices service;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Prestadores body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(body));
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello word";
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {
		Optional<Prestadores> oUser = service.findById(id);

		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oUser);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uptade(@RequestBody Prestadores agendaDetails, @PathVariable(value = "id") Integer id) {
		Optional<Prestadores> agenda = service.findById(id);

		if (!agenda.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(agendaDetails, agenda); 
//		agenda.get().setName(agendaDetails.getName());
//		agenda.get().setEmail(agendaDetails.getEmail());
//		agenda.get().setEnabled(agendaDetails.isEnabled());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(agenda.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> uptade(@PathVariable(value = "id") Integer id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Prestadores> fill() {
		List<Prestadores> agenda = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return agenda;
	}
}
