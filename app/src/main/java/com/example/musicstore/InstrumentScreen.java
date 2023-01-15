package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicstore.adapters.GaleriaInstrumentosAdapter;
import com.example.musicstore.model.Instrument;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InstrumentScreen extends AppCompatActivity {
    ImageView imageView;
    TextView txtTitle;
    GaleriaInstrumentosAdapter galeriaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_screen);

        imageView = findViewById(R.id.instrumentImageDesc);
        txtTitle = findViewById(R.id.txtInstrumentTitle);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_01, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_02, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_03, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_04, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_05, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_06, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_07, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_08, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_09, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_01, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_11, "Guitarra eléctrica"));
        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_12, "Guitarra eléctrica"));

        galeriaAdapter = new GaleriaInstrumentosAdapter(this, instruments);
//        imageView.setImageResource(((Instrument)galeriaAdapter.getItem(position)).getImage());
//        imageView.setImageResource();
        Picasso.get()
                .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        txtTitle.setText(((Instrument)galeriaAdapter.getItem(position)).getName());

    }
}