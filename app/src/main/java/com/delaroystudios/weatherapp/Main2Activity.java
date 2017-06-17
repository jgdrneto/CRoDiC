package com.delaroystudios.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.delaroystudios.weatherapp.data.SpinnerAdapter;
import com.delaroystudios.weatherapp.data.SpinnerOnItemSelectedListener;
import com.delaroystudios.weatherapp.data.TimePickerFragment;
import com.delaroystudios.weatherapp.principal.Preferencia;
import com.delaroystudios.weatherapp.principal.eventos.Alimentacao;
import com.delaroystudios.weatherapp.principal.eventos.Descanso;
import com.delaroystudios.weatherapp.principal.eventos.Evento;
import com.delaroystudios.weatherapp.principal.eventos.Exposicao;
import com.delaroystudios.weatherapp.principal.eventos.Lazer;
import com.delaroystudios.weatherapp.principal.eventos.Palestra;
import com.delaroystudios.weatherapp.principal.eventos.Turismo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Button btnIniTimePicker,btnTerTimePicker;
    private Spinner spinnerClasses;
    private ListView listaPreferencia;
    private SpinnerAdapter spinnerAdapter;
    private ArrayAdapter<Preferencia> listViewAdapter;
    private List<Class <? extends Evento>> classes;
    private List<Preferencia> preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnIniTimePicker =  (Button)findViewById(R.id.button_HoraInicio);
        btnTerTimePicker =  (Button)findViewById(R.id.button_HoraTermino);

        //==========================================================================

        preferencias  = new ArrayList<Preferencia>();

        listaPreferencia =  (ListView)findViewById(R.id.listView_listaPreferencias);

        listViewAdapter = new ArrayAdapter<Preferencia>(this, android.R.layout.simple_list_item_1, preferencias);

        listaPreferencia.setAdapter(listViewAdapter);

        //==========================================================================

        spinnerClasses   =  (Spinner)findViewById(R.id.spinner_Classes);

        classes = new ArrayList<Class <? extends Evento>>();
        classes.add(Alimentacao.class);
        classes.add(Descanso.class);
        classes.add(Exposicao.class);
        classes.add(Lazer.class);
        classes.add(Turismo.class);
        classes.add(Palestra.class);

        spinnerAdapter = new SpinnerAdapter(this,android.R.layout.simple_spinner_item,new ArrayList<Class <? extends Evento>>(classes));

        spinnerClasses.setAdapter(spinnerAdapter);

        spinnerClasses.setOnItemSelectedListener(new SpinnerOnItemSelectedListener(this,spinnerAdapter));

        //==========================================================================
    }

    private Date converterTextParaTimer(String tempo){

        if(tempo.equals("Hora de inicío") || tempo.equals("Hora de término") ) {
            return null;
        }else {
            int hora = Integer.parseInt(tempo.substring(0, tempo.indexOf(":")));

            int minuto = Integer.parseInt(tempo.substring(tempo.indexOf(":")+1, tempo.length() - 1));

            Date tempo_Date = new Date();

            tempo_Date.setHours(hora);
            tempo_Date.setMinutes(minuto);

            return tempo_Date;
        }
    }

    public void cliqueBotaoCriarRoteiro(View View){
        Context context = this;
        Class destinationClass = MainActivity.class;
        Intent intentToStartDetailActivity = new Intent(context, destinationClass);
        intentToStartDetailActivity.putExtra("Preferencias", (Serializable) preferencias);
        startActivity(intentToStartDetailActivity);
    }

    public void cliqueBotaoCancelarPreferencia(View View){
        spinnerAdapter.setListClasses(classes);

        spinnerAdapter.notifyDataSetChanged();

        listViewAdapter.clear();

        listViewAdapter.notifyDataSetChanged();

    }

    public void cliqueBotaoCriarPreferencia(View View){

        Date horaInicio = converterTextParaTimer(btnIniTimePicker.getText().toString());
        Date horaTermino = converterTextParaTimer(btnTerTimePicker.getText().toString());

        //Toast.makeText(this, horaInicio.getHours()+":"+horaInicio.getMinutes()+ "\n" + horaTermino.getHours() + ":" +horaTermino.getMinutes(), Toast.LENGTH_LONG).show();

        if(horaInicio==null || horaTermino==null){
            Toast.makeText(this, "Escolha hora de ínicio e hora de término", Toast.LENGTH_LONG).show();
        }else{
            if(horaInicio.after(horaTermino)){
                Toast.makeText(this, "Hora de inicio posterior a hora de término", Toast.LENGTH_LONG).show();

                btnIniTimePicker.setText("Hora de inicío");
                btnTerTimePicker.setText("Hora de término");
            }else {

                Class<? extends Evento> c = (Class<? extends Evento>) spinnerClasses.getSelectedItem();

                if (c == null) {
                    Toast.makeText(this, "Selecione uma classe", Toast.LENGTH_LONG).show();
                } else {
                    //Remove valor do spinner
                    spinnerAdapter.getListClasses().remove(spinnerClasses.getSelectedItem());

                    spinnerAdapter.notifyDataSetChanged();

                    preferencias.add(new Preferencia(c, horaInicio.getHours(), horaInicio.getMinutes(), horaTermino.getHours(), horaTermino.getMinutes()));

                    listViewAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void cliqueBotaoHoraInicio(View view){

        TimePickerFragment dialogFragment = new TimePickerFragment();

        dialogFragment.setBotao(btnIniTimePicker);

        dialogFragment.show(getSupportFragmentManager(), "time_picker");
    }

    public void cliqueBotaoHoraTermino(View view){

        TimePickerFragment dialogFragment = new TimePickerFragment();

        dialogFragment.setBotao(btnTerTimePicker);

        dialogFragment.show(getSupportFragmentManager(), "time_picker");
    }

}
