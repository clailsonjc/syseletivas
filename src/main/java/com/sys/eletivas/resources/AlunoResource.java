package com.sys.eletivas.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest ok";
	}


}