package com.delaroystudios.weatherapp.principal.eventos;

import java.util.GregorianCalendar;

public class Turismo extends Evento{

	public Turismo(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		super(nome,Turismo.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
	}

}
