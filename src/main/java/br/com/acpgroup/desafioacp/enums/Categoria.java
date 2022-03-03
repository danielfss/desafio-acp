package br.com.acpgroup.desafioacp.enums;

public enum Categoria {

	MOVEIS(0),
	ELETRONICOS(1),
	ELETRODOMESTICOS(2);
	
	private int code;
	
	private Categoria(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/**
	 * Procura pelo número inteiro e quando ele achar o Enum retorna a String
	 * @param code
	 * @return
	 */
	public static Categoria valueOf(int code) {
		for(Categoria value : Categoria.values()) {
			if(code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código da Categoria inválido");
	}
	
}
