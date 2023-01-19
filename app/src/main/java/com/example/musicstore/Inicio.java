package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ImageView ivPRoducto = findViewById(R.id.iconProducto);
        ImageView ivUsuario = findViewById(R.id.iconUsuario);
        //ImageView billi
        ImageView ivFaq = findViewById(R.id.iconFaq);

        Intent intentHome = new Intent(this, Inicio.class);
        Intent intentProducto = new Intent(this, InstrumentsGalery.class);
        Intent intentUsuario = new Intent(this, UserGestorActivity.class);
        //intent billy
        Intent intentFaq = new Intent(this, FaqActivity.class);

        ivPRoducto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentProducto);
                    }
                }
        );
        ivUsuario.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentUsuario);
                    }
                }
        );

        ivFaq.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentFaq);
                    }
                }
        );


    }
}