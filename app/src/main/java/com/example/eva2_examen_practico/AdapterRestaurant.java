package com.example.eva2_examen_practico;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRestaurant extends ArrayAdapter<Restaurant> {
    Context context;
    int resource;
    ArrayList<Restaurant> restaurants;

    public AdapterRestaurant(Context context, int resource, ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.restaurants = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgRestaurant;
        TextView txtVwNombre,  txtVwDescripcion, txtVwDireccionYTel;
        ImageView estrella1,estrella2,estrella3;

        //ConvertView es el layout que representa una fila en la lista
        if (convertView == null){
            //Crear nuestro Layout
            //Inflater
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }
        imgRestaurant = convertView.findViewById(R.id.imageViewMostrar);
        txtVwNombre = convertView.findViewById(R.id.textViewNombre);
        txtVwDescripcion = convertView.findViewById(R.id.textViewDescripcion);
        txtVwDireccionYTel = convertView.findViewById(R.id.textViewDireccion);
        estrella1 = convertView.findViewById(R.id.estrella1);
        estrella2 = convertView.findViewById(R.id.estrella2);
        estrella3 = convertView.findViewById(R.id.estrella3);

        imgRestaurant.setImageResource(restaurants.get(position).getImagen());
        txtVwNombre.setText(restaurants.get(position).getNombre());
        txtVwDescripcion.setText(restaurants.get(position).getDescripcion());
        txtVwDireccionYTel.setText(restaurants.get(position).getDireccionYTel());
        switch(restaurants.get(position).getEvaluacion()){
            case 1:
                estrella1.setBackgroundResource(R.drawable.estrella);
                estrella2.setBackgroundResource(R.drawable.estrella2);
                estrella3.setBackgroundResource(R.drawable.estrella2);
                break;
            case 2:
                estrella1.setBackgroundResource(R.drawable.estrella);
                estrella2.setBackgroundResource(R.drawable.estrella);
                estrella3.setBackgroundResource(R.drawable.estrella2);
                break;
            case 3:
                estrella1.setBackgroundResource(R.drawable.estrella);
                estrella2.setBackgroundResource(R.drawable.estrella);
                estrella3.setBackgroundResource(R.drawable.estrella);
                break;
            default:
                estrella1.setBackgroundResource(R.drawable.estrella2);
                estrella2.setBackgroundResource(R.drawable.estrella2);
                estrella3.setBackgroundResource(R.drawable.estrella2);
                break;
        }
        return convertView;
    }
}
