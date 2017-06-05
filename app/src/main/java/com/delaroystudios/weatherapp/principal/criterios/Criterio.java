package com.delaroystudios.weatherapp.principal.criterios;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.List;
import java.util.Random;

public abstract class Criterio {

	private Random geradorDeNumero = new Random();

	public abstract List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias);

	public Random getGeradorDeNumero() {
		return geradorDeNumero;
	}
}
