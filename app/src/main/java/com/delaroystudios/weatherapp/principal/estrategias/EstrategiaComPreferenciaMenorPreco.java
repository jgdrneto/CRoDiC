package com.delaroystudios.weatherapp.principal.estrategias;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.criterios.Criterio;
import com.delaroystudios.weatherapp.principal.criterios.CriterioDePreferencia;
import com.delaroystudios.weatherapp.principal.criterios.CriterioMenorPreco;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.io.Serializable;
import java.util.List;

public class EstrategiaComPreferenciaMenorPreco implements EstrategiaDeEscolha,Serializable{

	@Override
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias) {
		
		if(!eventos.isEmpty()){
			
			Criterio c = new CriterioDePreferencia();
			Criterio c2 =  new CriterioMenorPreco();

			List<Evento> lSaida = c2.aplicarCriterio(c.aplicarCriterio(eventos, preferencias),preferencias);

			return lSaida.get(c.getGeradorDeNumero().nextInt(lSaida.size()));
			
		}else{
			return null;
		}
	}

	@Override
	public String toString(){
		return "Estratégia com preferência e menor preço";
	}
}
