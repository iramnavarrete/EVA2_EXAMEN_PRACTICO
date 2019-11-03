package com.example.eva2_examen_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Evaluacion extends AppCompatActivity {
    ImageView imagen;
    TextView nombre;
    TextView descripcion;
    TextView dirytel;
    ImageView estrella1,estrella2,estrella3;
    SeekBar cali;
    Button captu;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        imagen = findViewById(R.id.imgRes);
        nombre = findViewById(R.id.txtNombre);
        descripcion = findViewById(R.id.txtDescrip);
        dirytel = findViewById(R.id.txtDireccion);
        estrella1 = findViewById(R.id.image1);
        estrella2 = findViewById(R.id.image2);
        estrella3 = findViewById(R.id.image3);
        cali = findViewById(R.id.seekBar);
        captu = findViewById(R.id.btnCapturar);

        i = getIntent();
        imagen.setBackgroundResource(i.getIntExtra("IMG",R.drawable.estrella));
        nombre.setText(i.getStringExtra("NAME"));
        descripcion.setText(i.getStringExtra("DESC"));
        dirytel.setText(i.getStringExtra("TEL"));
        cali.setProgress(i.getIntExtra("CAL",0));

        switch(i.getIntExtra("CAL",0)){
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

        captu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviar = getIntent();
                enviar.putExtra("NEW",cali.getProgress());
                enviar.putExtra("I",i.getIntExtra("I",1));
                setResult(Activity.RESULT_OK,enviar);
                finish();
            }
        });
    }
}
