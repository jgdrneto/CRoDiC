package com.delaroystudios.weatherapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.delaroystudios.weatherapp.data.SpinnerAdapter;
import com.delaroystudios.weatherapp.data.SpinnerOnItemSelectedListener;
import com.delaroystudios.weatherapp.data.TimePickerFragment;
import com.delaroystudios.weatherapp.principal.eventos.Alimentacao;
import com.delaroystudios.weatherapp.principal.eventos.Descanso;
import com.delaroystudios.weatherapp.principal.eventos.Evento;
import com.delaroystudios.weatherapp.principal.eventos.Exposicao;
import com.delaroystudios.weatherapp.principal.eventos.Lazer;
import com.delaroystudios.weatherapp.principal.eventos.Palestra;
import com.delaroystudios.weatherapp.principal.eventos.Turismo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Button btnIniTimePicker,btnTerTimePicker;
    private Spinner spinnerClasses;
    private SpinnerAdapter spinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnIniTimePicker =  (Button)findViewById(R.id.button_HoraInicio);
        btnTerTimePicker =  (Button)findViewById(R.id.button_HoraTermino);

        //==========================================================================

        spinnerClasses   =  (Spinner)findViewById(R.id.spinner_Classes);

        List<Class <? extends Evento>> classes = new ArrayList<Class <? extends Evento>>();
        classes.add(Alimentacao.class);
        classes.add(Descanso.class);
        classes.add(Exposicao.class);
        classes.add(Lazer.class);
        classes.add(Turismo.class);
        classes.add(Palestra.class);

        SpinnerAdapter adapter = new SpinnerAdapter(this,android.R.layout.simple_spinner_item,classes);

        spinnerClasses.setAdapter(adapter);

        spinnerClasses.setOnItemSelectedListener(new SpinnerOnItemSelectedListener(this,adapter));

        //==========================================================================

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
