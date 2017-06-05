package com.delaroystudios.weatherapp.principal.estrategias;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.criterios.Criterio;
import com.delaroystudios.weatherapp.principal.criterios.CriterioMenorPreco;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.List;

public class EstrategiaPorMenorPreco implements EstrategiaDeEscolha{

	@Override
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias) {
		if(!eventos.isEmpty()){
			
			Criterio c = new CriterioMenorPreco();

			List<Evento> lSaida = c.aplicarCriterio(eventos, preferencias);

			return lSaida.get(c.getGeradorDeNumero().nextInt(lSaida.size()));

		}else{
			return null;
		}
	}

}
