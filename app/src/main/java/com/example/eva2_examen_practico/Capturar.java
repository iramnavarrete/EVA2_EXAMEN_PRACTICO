package com.example.eva2_examen_practico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Capturar extends AppCompatActivity implements ImageView.OnClickListener {
    Restaurant restaurante;
    EditText nombre, descripcion, direccion;
    ImageView imagen;

    int REQUEST_CODE = 10;

    int idNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        imagen = findViewById(R.id.imageViewCapturar);
        nombre = findViewById(R.id.editTextNombre);
        descripcion = findViewById(R.id.editTextDescripcion);
        direccion = findViewById(R.id.editTextDireccion);
    }



    public void onClickGuardar(View v){
        //imagen
        Intent i = new Intent();
        restaurante = new Restaurant(idNuevo, nombre.getText().toString(), descripcion.getText().toString(), direccion.getText().toString(), 2);
        Bundle bundle = new Bundle();
        bundle.putSerializable("restaurante",restaurante);
        i.putExtras(bundle);
        setResult(RESULT_OK,i);
        finish();
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, SeleccionaImagen.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.hasExtra("imagen")){
                imagen.setImageResource(data.getExtras().getInt("imagen"));
                idNuevo = data.getExtras().getInt("imagen");
                data.removeExtra("imagen");
            }
        }
    }
}
