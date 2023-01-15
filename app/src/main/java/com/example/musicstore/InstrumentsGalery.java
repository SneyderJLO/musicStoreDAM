package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.musicstore.adapters.GaleriaInstrumentosAdapter;

public class InstrumentsGalery extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments_galery);

        gridView = findViewById(R.id.gridInstruments);
        gridView.setAdapter(new GaleriaInstrumentosAdapter(this));
        gridView.setNumColumns(3);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, InstrumentScreen.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}