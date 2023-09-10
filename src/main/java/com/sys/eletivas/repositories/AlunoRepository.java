package com.sys.eletivas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.eletivas.domain.Aluno;

@Repository()
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	
	

}
