package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Professor;
import com.sys.eletivas.repositories.ProfessorRepository;
import com.sys.eletivas.services.exceptions.MyDataIntegrityException;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repo;

	public Professor find(Integer id) {

		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}

	public Professor insert(Professor obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	// atualiza
	public Professor update(Professor obj) {
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
