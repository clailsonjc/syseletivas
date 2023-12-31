package com.sys.eletivas.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sys.eletivas.domain.Professor;
import com.sys.eletivas.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

	@Autowired
	ProfessorService service;

	@GetMapping
	public String inicio() {
		return "professor controller ok";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Professor> find(@PathVariable Integer id) {

		Professor obj = service.find(id);
		return ResponseEntity.ok(obj);

	}

	// salvar
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Professor obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	// atualizar
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Professor obj, @PathVariable Integer id) {

		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	// deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	
	

}//
