package com.example.eva2_examen_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SeleccionaImagen extends AppCompatActivity implements ImageView.OnClickListener {

    int[] imagenes = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
    };

    ImageView img1, img2, img3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_imagen);
        img1 = findViewById(R.id.imageViewSelec1);
        img2 = findViewById(R.id.imageViewSelec2);
        img3 = findViewById(R.id.imageViewSelec3);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.imageViewSelec1:
                intent.putExtra("imagen",R.drawable.f1);
                break;
            case R.id.imageViewSelec2:
                intent.putExtra("imagen", R.drawable.f2);
                break;
            case R.id.imageViewSelec3:
                intent.putExtra("imagen", R.drawable.f3);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, intent);

        finish();
    }
}
