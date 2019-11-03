package com.example.eva2_examen_practico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView listaRest;
    ArrayList<Restaurant> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listaRest = findViewById(R.id.listaRest);
        lista = (ArrayList<Restaurant>) getIntent().getExtras().getSerializable("lista");
        listaRest.setAdapter(new AdapterRestaurant(this, R.layout.activity_layout_mostrar, lista));
        listaRest.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //lista = (ArrayList<Restaurant>) getIntent().getSerializableExtra("lista");

        Intent intent = new Intent(this,Evaluacion.class);
        intent.putExtra("IMG",lista.get(i).getImagen());
        intent.putExtra("NAME",lista.get(i).getNombre());
        intent.putExtra("DESC",lista.get(i).getDescripcion());
        intent.putExtra("TEL",lista.get(i).getDireccionYTel());
        intent.putExtra("CAL",lista.get(i).getEvaluacion());
        intent.putExtra("I",i);
        startActivityForResult(intent,1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){ //resultCode es la seleccion que da el usuario
            int cali = data.getIntExtra("NEW",0);
            int position = data.getIntExtra("I",1);
            lista.get(position).setEvaluacion(cali);
            listaRest.setAdapter(new AdapterRestaurant(this, R.layout.activity_layout_mostrar, lista));

        }else {

        }
    }
}
