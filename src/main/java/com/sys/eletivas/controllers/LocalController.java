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

import com.sys.eletivas.domain.Local;
import com.sys.eletivas.services.LocalService;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {
	
	@Autowired
	LocalService service;
	
	@RequestMapping
	public String inicio() {
		return "Local controller ok";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
				
		Local obj = service.buscar(id);			
		return ResponseEntity.ok(obj) ;				
		
	}
	
	//salvar
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Local obj){
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	



	
	
	
	
}
