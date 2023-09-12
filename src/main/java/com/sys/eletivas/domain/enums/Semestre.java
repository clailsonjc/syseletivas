package com.sys.eletivas.domain.enums;

public enum Semestre {
	
	SEMESTRE1(1,"1º SEMESTRE"),
	SEMESTRE2(2,"2º SEMESTRE");
	
	private int cod;
	private String descricao;
	
	private Semestre(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static Semestre toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (Semestre x : Semestre.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id do Enum inválido:"+cod);
	}

}
