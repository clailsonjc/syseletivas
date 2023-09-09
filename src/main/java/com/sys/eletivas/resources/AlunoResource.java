package com.sys.eletivas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sys.eletivas.dmain.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Aluno> listar() {
		
		Integer x = 1234567891;
		Integer y = 1234567891;
		if(x.equals(y))
			System.out.println("números iguais");
		
		Aluno a1 =  new Aluno(1L, 1678542L, "Clailson", 1, "123456");
		Aluno a2 =  new Aluno(2L, 2678542L, "Pedro", 1, "123456");
		Aluno a3 =  new Aluno(3L, 3678542L, "José", 1, "123456");
		List<Aluno> lista = new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		return lista;
	}


	
	
	
	
	
}
