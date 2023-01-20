package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicstore.db.Conexion;

public class FaqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        //*************menu
        ImageView ivhome = findViewById(R.id.iconInicio);
        ImageView ivPRoducto = findViewById(R.id.iconProducto);
        ImageView ivUsuario = findViewById(R.id.iconUsuario);
        ImageView ivFaq = findViewById(R.id.iconFaq);
        Intent intentHome = new Intent(this, Inicio.class);
        Intent intentProducto = new Intent(this, InstrumentsGalery.class);
        Intent intentUsuario = new Intent(this, UserGestorActivity.class);
        Intent intentCarrito = new Intent(this,CarritoActivity.class);
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


        //*****************
//        btnGuardar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Conexion conexion = new Conexion(FaqActivity.this);
//                final SQLiteDatabase db = conexion.getWritableDatabase();
//
//                ContentValues cv = new ContentValues();
//                cv.put("descripcion", pregunta.getText().toString().trim());
//                db.insert("preguntas", null, cv);
//            }
//        });


    }
}