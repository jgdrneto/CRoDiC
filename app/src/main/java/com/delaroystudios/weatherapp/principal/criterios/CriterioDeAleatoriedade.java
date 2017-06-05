package com.delaroystudios.weatherapp.principal.criterios;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CriterioDeAleatoriedade extends Criterio{

	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias){
		
		List<Evento> le = new ArrayList<Evento>();
		
		if(!eventos.isEmpty()){
			
			for(Evento ev : eventos){
				if(getGeradorDeNumero().nextInt(2)==0){
					le.add(ev);
				}
			}
			
			//Se ninguem for selecionado pela aleatoriedade, pelo menos um é garantido
			if(le.isEmpty()){
				le.add(eventos.get(getGeradorDeNumero().nextInt(eventos.size())));
			}
		
		}
		
		return le;
	}
	
}
