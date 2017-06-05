package com.delaroystudios.weatherapp.principal;

import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.GregorianCalendar;



public class Preferencia implements Comparable<Preferencia>{
	
	private Class<? extends Evento> classe;
	private GregorianCalendar inicio;
	private GregorianCalendar fim;
	
	
	public Preferencia(Class<? extends Evento> classe, int horaInicio, int minInicio, int horaFim, int minFim) {
		this.classe = classe;
		this.inicio = new GregorianCalendar(0,0, 0, horaInicio, minInicio);
		this.fim = new GregorianCalendar(0,0, 0, horaFim, minFim);
	}

	public Class<? extends Evento> getClasse() {
		return classe;
	}

	public void setClasse(Class<? extends Evento> classe) {
		this.classe = classe;
	}

	public GregorianCalendar getInicio() {
		return inicio;
	}

	public void setInicio(GregorianCalendar inicio) {
		this.inicio = inicio;
	}

	public GregorianCalendar getFim() {
		return fim;
	}

	public void setFim(GregorianCalendar fim) {
		this.fim = fim;
	}

	@Override
	public int compareTo(Preferencia pref) {
		
		if(inicio.getTimeInMillis()>fim.getTimeInMillis()){
			return -1;
		}else{
			if(inicio.getTimeInMillis()<fim.getTimeInMillis()){
				return 1;
			}else{
				return 0;
			}
		}
	}
}
