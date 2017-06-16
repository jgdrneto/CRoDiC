package com.delaroystudios.weatherapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.delaroystudios.weatherapp.data.TimePickerFragment;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    public Button btnIniTimePicker,btnTerTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnIniTimePicker =  (Button)findViewById(R.id.button_HoraInicio);
        btnTerTimePicker =  (Button)findViewById(R.id.button_HoraTermino);

        /*
        btnIniTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerFragment dialogFragment = new TimePickerFragment();

                dialogFragment.setBotao(btnIniTimePicker);

                dialogFragment.show(getSupportFragmentManager(), "time_picker");
            }
        });

        btnTerTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerFragment dialogFragment = new TimePickerFragment();

                dialogFragment.setBotao(btnTerTimePicker);

                dialogFragment.show(getSupportFragmentManager(), "time_picker");
            }
        });
        */
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
