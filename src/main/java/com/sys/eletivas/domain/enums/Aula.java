package com.sys.eletivas.domain.enums;

public enum Aula {
	
	AULA1(1,"AULA 1"),
	AULA2(2,"AULA 2"),
	AULA3(3,"AULA 3"),
	AULA4(4,"AULA 4"),
	AULA5(5,"AULA 5"),
	AULA6(6,"AULA 6"),
	AULA7(7,"AULA 7"),
	AULA8(8,"AULA 8"),
	AULA9(9,"AULA 9"),
	AULA10(10,"AULA 10"),
	AULA11(11,"AULA 11"),
	AULA12(12,"AULA 12");
	
	
	private int cod;
	private String descricao;
	
	private Aula(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static Aula toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (Aula x : Aula.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id do Enum inválido:"+cod);
	}
	
	
	

}
