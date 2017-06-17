package com.delaroystudios.weatherapp.data;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.delaroystudios.weatherapp.principal.eventos.Evento;

import java.util.List;

/**
 * Created by neto on 16/06/17.
 */

public class SpinnerAdapter extends ArrayAdapter<Class<? extends Evento>> {

    Context contexto;

    List<Class<? extends Evento>>  classes;

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Class<? extends Evento>> lista) {
        super(context, resource, lista);

        this.contexto = context;
        this.classes = lista;
    }

    public int getCount(){
        return this.classes.size();
    }

    public Class<? extends Evento> getItem(int position){
        return classes.get(position);
    }

    public void setListClasses(List<Class<? extends Evento>> lClasses){
        this.classes = lClasses;
    }

    public List<Class<? extends Evento>> getListClasses(){
        return this.classes;
    }

    public long getItemId(int position){
        return position;
    }

    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = new TextView(contexto);
        label.setTextColor(Color.BLACK);
        label.setGravity(Gravity.CENTER);
        label.setTextSize(30);

        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(classes.get(position).getSimpleName());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(contexto);
        label.setTextColor(Color.BLACK);
        label.setTextSize(30);
        label.setGravity(Gravity.CENTER);
        label.setText(classes.get(position).getSimpleName());

        return label;
    }

}
