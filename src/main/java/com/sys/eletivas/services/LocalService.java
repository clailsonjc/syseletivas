package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Local;
import com.sys.eletivas.repositories.LocalRepository;
import com.sys.eletivas.services.exceptions.MyDataIntegrityException;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class LocalService {

	@Autowired
	LocalRepository repo;

	public Local find(Integer id) {

		Optional<Local> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Local.class.getName()));
	}
	
	//salvar
	public Local insert(Local obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	// atualiza
	public Local update(Local obj) {
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
