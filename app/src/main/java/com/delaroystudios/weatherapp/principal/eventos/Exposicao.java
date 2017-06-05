package com.delaroystudios.weatherapp.principal.eventos;


import java.util.GregorianCalendar;

import org.json.simple.JSONObject;

public class Exposicao extends Evento{
	
	private String autor;

	public Exposicao(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino, String autor) {
		super(nome,Exposicao.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public JSONObject converterParaJSON() {
		
		JSONObject json = super.converterParaJSON();	
		json.put("Autor" , this.autor);
		
		return json;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Autor: " + this.getAutor()+"\n";
	}	
	
}
