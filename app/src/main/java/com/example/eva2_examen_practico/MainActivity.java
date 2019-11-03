package com.example.eva2_examen_practico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Restaurant> lista;
    int REQUEST_CODE = 11;
    Intent i;
    Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();
        salir = findViewById(R.id.btnSalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void onClickCapturar(View v){
        i = new Intent(this,Capturar.class);
        startActivityForResult(i,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.getExtras()!=null){
                lista.add((Restaurant) data.getExtras().getSerializable("restaurante"));
                //Toast.makeText(this,"se agregó",Toast.LENGTH_SHORT).show();
                data.removeExtra("restaurante");
            }
        }
    }

    public void onClickMostrar(View v){
        i = new Intent(this,Mostrar.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",lista);
        i.putExtras(bundle);
        startActivity(i);

    }
   public ArrayList<Restaurant> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Restaurant> lista) {
        this.lista = lista;
    }

    public void imprimir(View v){
        for (int i = 0;i < lista.size();i++){
            //Toast.makeText(this,lista.get(i).getNombre(),Toast.LENGTH_SHORT).show();
            Log.wtf("Restaurante", lista.get(i).getNombre());
        }
    }


}
