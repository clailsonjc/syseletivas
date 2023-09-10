package com.sys.eletivas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Turma implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTurma;
	
	private String descricao;
	
	private Integer ano;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "turma_aluno",
		joinColumns = @JoinColumn(name = "id_turma"),				      
		inverseJoinColumns = @JoinColumn(name = "id_aluno")
	)
	private List<Aluno> alunos = new ArrayList<>();
	
	
	
	
	
	public Turma() {
	}

	public Turma(Integer idTurma, String descricao) {
		super();
		this.idTurma = idTurma;
		this.descricao = descricao;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	//listas
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
		

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(descricao, other.descricao);
	}

	
	
	
	
	
	
	

}
