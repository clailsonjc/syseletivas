package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Eletiva;
import com.sys.eletivas.repositories.EletivaRepository;
import com.sys.eletivas.services.exceptions.MyDataIntegrityException;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class EletivaService {

	@Autowired
	EletivaRepository repo;

	public Eletiva find(Integer id) {

		Optional<Eletiva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Eletiva.class.getName()));
	}

	// salvar
	public Eletiva insert(Eletiva obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// atualizar
	public Eletiva update(Eletiva obj) {
		
		find(obj.getId());		
		return repo.save(obj);
	}

	// delete
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new MyDataIntegrityException("Não é possível excluir objetos com dependências!");
		}
	}

		
	
	
	
	

}//
