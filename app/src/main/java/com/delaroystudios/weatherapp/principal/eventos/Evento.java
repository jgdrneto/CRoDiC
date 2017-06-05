package com.delaroystudios.weatherapp.principal.eventos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class Evento {
	
	public enum QUALIDADE_EVE{
		MEDIA,
		BOA,
		EXCELENTE
	}	
	
	public static String NOME ="Nome";
	public static String QUALIDADE ="Qualidade";
	public static String DESCRICAO ="Descrição";
	public static String LOCAL = "Local";
	public static String TIPO = "Tipo";
	public static String PRECO = "Preço";
	public static String HORADEINICIO = "Hora de início";
	public static String HORADETERMINO = "Hora de término";
	
	private String nome;
	private String tipo;
	private String descricao;
	private String local;
	private double preco;
	private GregorianCalendar horarioInicio;
	private GregorianCalendar horarioTermino;
	
	public Evento(){
		
	}
	
	public Evento(String nome,String tipo, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		
		if(horarioInicio.after(horarioTermino)){
			System.out.println("Horário de término antes do horário de inicio do evento");
			System.out.println("Nome do evento em que isto ocorre : " + nome);
			System.exit(-1);
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
		this.preco = preco;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public GregorianCalendar getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(GregorianCalendar horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public GregorianCalendar getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(GregorianCalendar horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	
	@Override
	public String toString() {
		
		String result ="";
		
		result+="Nome: "+ this.getNome()+"\n";
		result+="Descrição: "+ this.getDescricao()+"\n";
		result+="Local: "+ this.getLocal()+"\n";
		result+="Preço: " + this.getPreco()+"\n";
		result+="Data de início: "+ this.getHorarioInicio().get(Calendar.DAY_OF_MONTH)+"/"+(this.getHorarioInicio().get(Calendar.MONTH)+1)+"/"+this.getHorarioInicio().get(Calendar.YEAR)+ " HORA: "+ this.getHorarioInicio().get(Calendar.HOUR_OF_DAY)+":"+this.getHorarioInicio().get(Calendar.MINUTE)+"\n";
		result+="Data de Término: "+ this.getHorarioTermino().get(Calendar.DAY_OF_MONTH)+"/"+(this.getHorarioTermino().get(Calendar.MONTH)+1)+"/"+this.getHorarioTermino().get(Calendar.YEAR)+ " HORA: "+ this.getHorarioTermino().get(Calendar.HOUR_OF_DAY)+":"+this.getHorarioTermino().get(Calendar.MINUTE)+"\n";
	
		return result;
	}

	public JSONObject converterParaJSON(){
		JSONObject json = new JSONObject();
		
		json.put(NOME, this.nome);
		json.put(TIPO, this.tipo);
		json.put(DESCRICAO, this.descricao);
		json.put(LOCAL, this.local);
		json.put(PRECO, this.preco);
		
		JSONArray horaInicio = new JSONArray();
		
		horaInicio.add(this.horarioInicio.get(Calendar.YEAR));
		horaInicio.add(this.horarioInicio.get(Calendar.MONTH));
		horaInicio.add(this.horarioInicio.get(Calendar.DAY_OF_MONTH));
		horaInicio.add(this.horarioInicio.get(Calendar.HOUR_OF_DAY));
		horaInicio.add(this.horarioInicio.get(Calendar.MINUTE));
		
		json.put(HORADEINICIO, horaInicio);
		
		JSONArray horaTermino = new JSONArray();
		
		horaTermino.add(this.horarioTermino.get(Calendar.YEAR));
		horaTermino.add(this.horarioTermino.get(Calendar.MONTH));
		horaTermino.add(this.horarioTermino.get(Calendar.DAY_OF_MONTH));
		horaTermino.add(this.horarioTermino.get(Calendar.HOUR_OF_DAY));
		horaTermino.add(this.horarioTermino.get(Calendar.MINUTE));
		
		json.put(HORADETERMINO,horaTermino);
		
		return json;
	}
	
	public static Map<String,Object> obterValoresApartirDoJSON(JSONObject obj){
		
		String tipo = (String) obj.get(Evento.TIPO);
		String nome = (String) obj.get(Evento.NOME);
		String descricao = (String) obj.get(Evento.DESCRICAO);
		String local = (String) obj.get(Evento.LOCAL);
		double preco = (double) obj.get(Evento.PRECO);
		JSONArray  ahi = (JSONArray)obj.get(Evento.HORADEINICIO);
		JSONArray aht = (JSONArray)obj.get(Evento.HORADETERMINO);
		
		Integer ano = Integer.valueOf((ahi.get(0).toString()));
		Integer mes = Integer.valueOf((ahi.get(1).toString()));
		Integer dia = Integer.valueOf((ahi.get(2).toString()));
		Integer hora = Integer.valueOf((ahi.get(3).toString()));
		Integer minuto = Integer.valueOf((ahi.get(4).toString()));
		
		GregorianCalendar hi = new GregorianCalendar(ano, mes,dia,hora, minuto);
		
		ano = Integer.valueOf((aht.get(0).toString()));
		mes = Integer.valueOf((aht.get(1).toString()));
		dia = Integer.valueOf((aht.get(2).toString()));
		hora = Integer.valueOf((aht.get(3).toString()));
		minuto = Integer.valueOf((aht.get(4).toString()));
		
		GregorianCalendar ht = new GregorianCalendar(ano, mes,dia,hora, minuto);
		
		Map<String,Object> valores = new HashMap<String,Object>();
			
		valores.put(NOME, nome);
		valores.put(TIPO, tipo);
		valores.put(DESCRICAO, descricao);
		valores.put(PRECO, preco);
		valores.put(LOCAL,local);
		valores.put(HORADEINICIO,hi);
		valores.put(HORADETERMINO, ht);

		return valores;		
	}
}
