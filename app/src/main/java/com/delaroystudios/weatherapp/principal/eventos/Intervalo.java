package com.delaroystudios.weatherapp.principal.eventos;

import java.util.GregorianCalendar;

public class Intervalo extends Evento {

	public Intervalo(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		super(nome,Intervalo.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
	}
	
}
