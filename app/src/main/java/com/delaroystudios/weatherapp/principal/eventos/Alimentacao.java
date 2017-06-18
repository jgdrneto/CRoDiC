package com.delaroystudios.weatherapp.principal.eventos;

import java.util.GregorianCalendar;
import java.util.Map;

import org.json.simple.JSONObject;

public class Alimentacao extends Evento{
	
	private QUALIDADE_EVE qualidade;
	
	public Alimentacao(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio,
			GregorianCalendar horarioTermino, QUALIDADE_EVE qualidade) {
		super(nome,Alimentacao.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
		this.qualidade = qualidade;
	}

	public QUALIDADE_EVE getQualidade() {
		return qualidade;
	}

	public void setQualidade(QUALIDADE_EVE qualidade) {
		this.qualidade = qualidade;
	}
	
	@Override
	public JSONObject converterParaJSON() {
		
		JSONObject json = super.converterParaJSON();	
		json.put("Qualidade" , this.qualidade.ordinal());
		
		return json;
	}

	@Override
	public String toString() {
		return super.toString() + "Qualidade: " + this.qualidade.name()+"\n";
	}	
	
}
