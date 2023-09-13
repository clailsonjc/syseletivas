package com.sys.eletivas.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sys.eletivas.domain.Aluno;
import com.sys.eletivas.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	AlunoService service;

	@RequestMapping
	public String inicio() {
		return "Aluno Controller ok";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Aluno obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

	// salvar
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	
	
	
	

}//
