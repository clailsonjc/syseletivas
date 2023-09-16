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

import com.sys.eletivas.domain.Eletiva;
import com.sys.eletivas.services.EletivaService;

@RestController
@RequestMapping(value = "/eletivas")
public class EletivaController {

	@Autowired
	EletivaService service;

	@GetMapping
	public String inicio() {
		return "Eletiva controller ok";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Eletiva> find(@PathVariable Integer id) {

		Eletiva obj = service.find(id);
		return ResponseEntity.ok(obj);

	}

	// salvar
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Eletiva obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	// atualizar
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Eletiva obj, @PathVariable Integer id) {		
		
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
