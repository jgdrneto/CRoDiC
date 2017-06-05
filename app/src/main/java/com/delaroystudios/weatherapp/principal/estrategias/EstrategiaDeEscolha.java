package com.delaroystudios.weatherapp.principal.estrategias;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.List;

public interface EstrategiaDeEscolha {
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias);
}
