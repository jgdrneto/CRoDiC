package com.delaroystudios.weatherapp.principal;

import com.delaroystudios.weatherapp.principal.estrategias.EstrategiaDeEscolha;
import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class ConstrutorDeRoteiro {
	
	private List<Evento> todosEventos;
	private List<List<Evento>> matrizEvento;
	private List<Evento> roteiro;
	private List<Class<? extends Evento>> classes;
	private List<Preferencia> preferencias;
	private GregorianCalendar data;
	
	public ConstrutorDeRoteiro(List<Evento> todosEventos, List<Class<? extends Evento>> classes, List<Preferencia> preferencias,int ano, int mes, int dia, int hora) {
		this.todosEventos = todosEventos;
		this.classes = classes;
		this.data = new GregorianCalendar(ano, mes, dia, hora, 0);
		this.preferencias = preferencias;
	}
	
	public List<List<Evento>> selecionarRoteirosPossiveis(){
		
		List<List<Evento>> tempRoteiro = new ArrayList<List<Evento>>();
		
		List<Integer> horas = new ArrayList<Integer>();
	
		for(Evento e : todosEventos){
			if(classes.contains(e.getClass()) && data.get(Calendar.DAY_OF_MONTH)==e.getHorarioInicio().get(Calendar.DAY_OF_MONTH)
											  && data.get(Calendar.MONTH) == e.getHorarioInicio().get(Calendar.MONTH)
											  && data.get(Calendar.YEAR) == e.getHorarioInicio().get(Calendar.YEAR)){
				
				if(horas.contains(e.getHorarioInicio().get(Calendar.HOUR_OF_DAY))){
					
					int idLHoras = horas.indexOf(e.getHorarioInicio().get(Calendar.HOUR_OF_DAY));
					
					tempRoteiro.get(idLHoras).add(e);
					
				}else{
					horas.add(e.getHorarioInicio().get(Calendar.HOUR_OF_DAY));
					tempRoteiro.add(new ArrayList<Evento>());
					tempRoteiro.get(horas.size()-1).add(e);
				}
			
			}
		}
		
		Collections.sort(horas);
		
		for(int i=0;i<(horas.size());i++){
			
			int id = buscaIdPorHora(horas.get(i),tempRoteiro);
						
			Collections.swap(tempRoteiro,i, id);
		
		}
		
		return tempRoteiro;
		
	}
	
	private int buscaIdPorHora(int hora, List<List<Evento>> tempRoteiro){
		
		for(int i =0;i<tempRoteiro.size();i++){
			if(tempRoteiro.get(i).get(0).getHorarioInicio().get(Calendar.HOUR_OF_DAY)==hora){
				return i;
			}
		}
		
		return -1;
	}
	
	private List<Evento> criarRoteiro(EstrategiaDeEscolha s){
		
		matrizEvento = selecionarRoteirosPossiveis();
		
		List<Evento> r =  new ArrayList<Evento>();	
		
		int horaAtual = matrizEvento.get(0).get(0).getHorarioInicio().get(Calendar.HOUR_OF_DAY);
		
		for(int i =0; i< matrizEvento.size();i++){
			
			if(horaAtual<=matrizEvento.get(i).get(0).getHorarioInicio().get(Calendar.HOUR_OF_DAY)){
				Evento e = s.escolher(matrizEvento.get(i), preferencias);
				r.add(e);
				horaAtual = e.getHorarioTermino().get(Calendar.HOUR_OF_DAY);	
			}
		}
		
		return r;
	}
	
	private void atualizarRoteiro(){
		//Ainda não implementado
	}
	
	public void RemoverEventoDoRoteiro(Evento v){
		
		this.roteiro.remove(v); 
		
		atualizarRoteiro();
	} 
	
	public List<Evento> getRoteiro(EstrategiaDeEscolha s) {
		
		this.roteiro = criarRoteiro(s);
		
		return roteiro;
	}

		
}
