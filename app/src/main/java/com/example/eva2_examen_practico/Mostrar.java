package com.example.eva2_examen_practico;

import androidx.appcompat.app.AppCompatActivity;

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
        Bundle bundle = new Bundle();
        bundle.putSerializable("restaurante",lista);
        intent.putExtras(bundle);

        Toast.makeText(this, lista.get(i).getNombre(),Toast.LENGTH_SHORT).show();
        Log.wtf("Restaurant", ""+lista.get(i).getNombre());
    }
}
