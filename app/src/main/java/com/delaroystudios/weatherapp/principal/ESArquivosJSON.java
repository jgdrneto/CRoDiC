package com.delaroystudios.weatherapp.principal;

import com.delaroystudios.weatherapp.principal.eventos.Alimentacao;
import com.delaroystudios.weatherapp.principal.eventos.Descanso;
import com.delaroystudios.weatherapp.principal.eventos.Evento;
import com.delaroystudios.weatherapp.principal.eventos.Exposicao;
import com.delaroystudios.weatherapp.principal.eventos.Intervalo;
import com.delaroystudios.weatherapp.principal.eventos.Lazer;
import com.delaroystudios.weatherapp.principal.eventos.Palestra;
import com.delaroystudios.weatherapp.principal.eventos.Turismo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ESArquivosJSON {
	
	List<Evento> eventos;
	
	
	public List<Evento> leitorJSONArray(InputStream arquivo) throws IOException, ParseException {
		
		List<Evento> events = new ArrayList<Evento>();
		
		JSONParser parser=new JSONParser();

		JSONArray obj = (JSONArray) parser.parse(new InputStreamReader(arquivo));
		
		for(Object o : obj){
			JSONObject jo = (JSONObject)o;
			
			events.add(convertJsonOBJParaEvento(jo));
			
		}
				
		return events;
	}	
	
	private Evento convertJsonOBJParaEvento(JSONObject obj) {
				
		Map<String,Object> valores = Evento.obterValoresApartirDoJSON(obj);

		switch(valores.get(Evento.TIPO).toString()){
			case "Alimentacao":
				
				Integer qualA = Integer.valueOf(obj.get(Alimentacao.QUALIDADE).toString());
				
				Evento.QUALIDADE_EVE qA = Evento.QUALIDADE_EVE.values()[qualA];
				
				return new Alimentacao((String)valores.get(Evento.NOME),
								 (String)valores.get(Evento.DESCRICAO),
								 (String)valores.get(Evento.LOCAL),
								 (double)valores.get(Evento.PRECO),
								 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
								 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
								 qA);
			case "Descanso":
				
				Integer qualD = Integer.valueOf(obj.get(Alimentacao.QUALIDADE).toString());
				
				Evento.QUALIDADE_EVE qD = Evento.QUALIDADE_EVE.values()[qualD];
				
				return new Descanso((String)valores.get(Evento.NOME),
								 (String)valores.get(Evento.DESCRICAO),
								 (String)valores.get(Evento.LOCAL),
								 (double)valores.get(Evento.PRECO),
								 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
								 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
								 qD);
				
			case "Exposicao" :

				valores = Exposicao.obterValoresExpApartirDoJSON(obj);

				return new Exposicao((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
						 (String)(valores.get("Autor")));
			case "Intervalo" :
				return new Intervalo((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			case "Lazer" :
				return new Lazer((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			case "Palestra" :

				valores = Palestra.obterValoresPalApartirDoJSON(obj);

				return new Palestra((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
						 (String)(valores.get("Palestrante")));
			case "Turismo" :
				return new Turismo((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			default:
				return null;
		}
	}
	
	public void escritor(String nomeArquivo, JSONArray json) throws IOException {
		
		FileWriter writeFile = null;
		
		try{
			writeFile = new FileWriter(nomeArquivo);
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(json.toJSONString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void escritor(String nomeArquivo, JSONObject json) throws IOException {
		
		FileWriter writeFile = null;
		
		try{
			writeFile = new FileWriter(nomeArquivo);
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(json.toJSONString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
