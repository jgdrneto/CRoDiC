package com.delaroystudios.weatherapp.principal.estrategias;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.criterios.Criterio;
import com.delaroystudios.weatherapp.principal.criterios.CriterioDePreferencia;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.io.Serializable;
import java.util.List;

public class EstrategiaComPreferencia implements EstrategiaDeEscolha,Serializable {

	@Override
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias) {
		
		if(!eventos.isEmpty()){
			
			Criterio c = new CriterioDePreferencia();

			List<Evento> lSaida =  c.aplicarCriterio(eventos, preferencias);

			return lSaida.get(c.getGeradorDeNumero().nextInt(lSaida.size()));
			
		}else{
			return null;
		}
	}

	@Override
	public String toString(){
		return "Estratégia com Preferência";
	}
}
