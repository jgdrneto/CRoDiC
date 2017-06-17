package com.delaroystudios.weatherapp.data;

import android.app.Activity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.delaroystudios.weatherapp.principal.eventos.Evento;

/**
 * Created by neto on 16/06/17.
 */

public class SpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    ArrayAdapter adapter;

    Activity tela;

    public SpinnerOnItemSelectedListener(Activity nTela, ArrayAdapter nAdapter){
        this.adapter = nAdapter;
        this.tela =  nTela;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Here you get the current item (a User object) that is selected by its position
        Class<? extends Evento> classe = (Class<? extends Evento>) adapter.getItem(position);
        // Here you can do the action you want to...
        Toast.makeText(this.tela, classe.getSimpleName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
