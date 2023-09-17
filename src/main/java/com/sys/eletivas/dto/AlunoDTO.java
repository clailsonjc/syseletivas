package com.sys.eletivas.dto;

import java.io.Serializable;

import com.sys.eletivas.domain.Aluno;

import jakarta.validation.constraints.NotBlank;


public class AlunoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;	
	private Integer matrícula;
	
	@NotBlank(message="O nome não pode ser nulo")
	private String nome;
	
	private Integer sexo;	
	private String senha;
	
	
	public AlunoDTO() {		
	}
	
	public AlunoDTO(Aluno obj) {
		this.id = obj.getId();
		this.matrícula = obj.getMatrícula();
		this.nome = obj.getNome();
		this.sexo = obj.getSexo();
		this.senha = obj.getSenha();
		
	}


	public AlunoDTO(Integer id, Integer matrícula, String nome, Integer sexo, String senha) {
		super();
		this.id = id;
		this.matrícula = matrícula;
		this.nome = nome;
		this.sexo = sexo;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMatrícula() {
		return matrícula;
	}


	public void setMatrícula(Integer matrícula) {
		this.matrícula = matrícula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getSexo() {
		return sexo;
	}


	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}//
