package com.delaroystudios.weatherapp.principal.eventos;

import java.util.GregorianCalendar;

import org.json.simple.JSONObject;

public class Palestra extends Evento{
	
	String palestrante;
	
	public Palestra(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino, String palestrante) {
		super(nome,Palestra.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
		this.palestrante = palestrante;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}	
	
	@Override
	public JSONObject converterParaJSON() {
		
		JSONObject json = super.converterParaJSON();	
		json.put("Palestrante" , this.palestrante);
		
		return json;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Palestrante: " + this.getPalestrante()+"\n";
	}	
}
