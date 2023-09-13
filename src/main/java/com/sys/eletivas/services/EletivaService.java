package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Eletiva;
import com.sys.eletivas.repositories.EletivaRepository;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class EletivaService {

	@Autowired
	EletivaRepository repo;

	public Eletiva buscar(Integer id) {

		Optional<Eletiva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Eletiva.class.getName()));
	}
	
	
	//salvar
		public Eletiva insert(Eletiva obj) {
			obj.setId(null);
			return repo.save(obj);
		}
	
	
	
	
	
	
	

}//
