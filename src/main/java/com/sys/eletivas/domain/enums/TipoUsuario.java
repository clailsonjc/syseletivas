package com.sys.eletivas.domain.enums;

public enum TipoUsuario {
	
	ESTUDANTE(1,"Aluno"),
	PROFESSOR(2,"Professor"),
	ADMIN(3,"Administrador");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static TipoUsuario toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TipoUsuario x : TipoUsuario.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id do Enum inválido:"+cod);
	}

}
