package com.senai.easteregg.modelo;

public class Parametros {

	private Integer id;
	private String descricao;
	private String valor;



	public Parametros(Integer id, String descricao, String valor) {
		super();
		this.setId(id);
		this.setDescricao(descricao);	
		this.setValor(valor);
	}

	public Parametros() {

	}
	
	@Override
	public String toString() {
		return getDescricao() + " - "  + getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
