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

import com.sys.eletivas.domain.Local;
import com.sys.eletivas.services.LocalService;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {

	@Autowired
	LocalService service;

	@GetMapping
	public String inicio() {
		return "Local controller ok";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Local> find(@PathVariable Integer id) {

		Local obj = service.find(id);
		return ResponseEntity.ok(obj);

	}

	// salvar
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Local obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	// atualizar
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Local obj, @PathVariable Integer id) {

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
