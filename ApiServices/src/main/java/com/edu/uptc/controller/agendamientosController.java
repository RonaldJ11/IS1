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

import com.edu.uptc.entity.Agendamientos;
import com.edu.uptc.services.agendamiendosService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })

@RequestMapping("/api/agendas")
public class agendamientosController {
	@Autowired
	private agendamiendosService service;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Agendamientos body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(body));
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello word";
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id_agendamiento") Integer id) {
		Optional<Agendamientos> oUser = service.findById(id);

		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oUser);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> uptade(@RequestBody Agendamientos agendaDetails, @PathVariable(value = "id_agendamiento") Integer id) {
		Optional<Agendamientos> agenda = service.findById(id);

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
	public ResponseEntity<?> uptade(@PathVariable(value = "id_agendamiento") Integer id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Agendamientos> fill() {
		List<Agendamientos> agenda = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return agenda;
	}
}
