package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FaqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);


        //*************menu
        ImageView ivhome = findViewById(R.id.iconInicio);
        ImageView ivPRoducto = findViewById(R.id.iconProducto);
        //ImageView billi
        //ImageView pradin
        ImageView ivFaq = findViewById(R.id.iconFaq);
        Intent intentHome = new Intent(this, Inicio.class);
        Intent intentProducto = new Intent(this, InstrumentsGalery.class);
        //intent billy
        //intent pradin
        Intent intentFaq = new Intent(this, FaqActivity.class);

        ivhome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentHome);
                    }
                }
        );

        ivPRoducto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentProducto);
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

        //*****************

    }
}