package br.com.acpgroup.desafioacp.enums;

public enum StatusProduto {

	DISPONIVEL(0),
	INDISPONIVEL(1);
	
	private int code;
	
	private StatusProduto(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusProduto valueOf(int code) {
		for(StatusProduto value : StatusProduto.values()) {
			if(code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código do StatusProduto inválido");
	}
}
