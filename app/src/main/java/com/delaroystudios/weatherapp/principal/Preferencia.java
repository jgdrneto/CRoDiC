package com.delaroystudios.weatherapp.principal;

import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Preferencia implements Comparable<Preferencia>,Serializable{
	
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

	private String converterCalendarParaStringTempo(Calendar c){
		String hora="";
		String minuto="";

		if(c.get(Calendar.HOUR_OF_DAY)<10){
			hora="0"+ c.get(Calendar.HOUR_OF_DAY);
		}else{
			hora = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		}

		if(c.get(Calendar.MINUTE)<10){
			minuto="0"+ c.get(Calendar.MINUTE);
		}else{
			minuto = String.valueOf(c.get(Calendar.MINUTE));
		}

		return hora+":"+minuto;
	}

	@Override
	public String toString() {
		return "Evento: " + classe.getSimpleName() + " "+ "Inicio: "+ converterCalendarParaStringTempo(inicio) + " Fim: " + converterCalendarParaStringTempo(fim);
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
