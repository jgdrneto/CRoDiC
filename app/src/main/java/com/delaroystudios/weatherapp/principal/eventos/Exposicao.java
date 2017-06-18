package com.delaroystudios.weatherapp.principal.eventos;


import java.util.GregorianCalendar;
import java.util.Map;

import org.json.simple.JSONObject;

public class Exposicao extends Evento{
	
	public String autor;

	public Exposicao(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino, String nAutor) {
		super(nome,Exposicao.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
		this.autor = nAutor;
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

	public static Map<String,Object> obterValoresExpApartirDoJSON(JSONObject obj){
		Map<String,Object> valores = Evento.obterValoresApartirDoJSON(obj);
		valores.put("Autor",obj.get("Autor"));
		return valores;
	}

	@Override
	public String toString() {
		return (super.toString() + "Autor: " + this.autor);
	}	
	
}
