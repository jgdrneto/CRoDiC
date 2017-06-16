package com.delaroystudios.weatherapp.data;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TimePicker;


public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    Button botao;

    public void setBotao(Button botao) {
        this.botao = botao;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int hours = 6;
        int minute = 0;
        boolean is24Hours = true;


        return new TimePickerDialog(getActivity(),this,hours,minute,is24Hours);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int menute) {
        botao.setText(hours+":"+menute);
    }
}