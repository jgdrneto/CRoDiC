package com.delaroystudios.weatherapp.principal.criterios;

import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CriterioDePreferencia extends Criterio{

	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias){
		
		List<Evento> le = new ArrayList<Evento>();
		
		if(!eventos.isEmpty()){
			
			if(!preferencias.isEmpty()){
								
				Collections.sort(preferencias);
				
				for(Preferencia pf : preferencias){
					for(Evento ev : eventos){
						
						if((pf.getInicio().get(Calendar.HOUR_OF_DAY)< ev.getHorarioInicio().get(Calendar.HOUR_OF_DAY)) ||
						   (pf.getInicio().get(Calendar.HOUR_OF_DAY)== ev.getHorarioInicio().get(Calendar.HOUR_OF_DAY) && pf.getInicio().get(Calendar.MINUTE)<=ev.getHorarioInicio().get(Calendar.MINUTE))){
							le.add(ev);
						}
					}
				}
				
				//Se ninguem foi escolhido
				if(le.isEmpty()){
					return eventos;
				}
				
			}else{
				return eventos;
			}	
		}
		
		return le;
	}
	
}
