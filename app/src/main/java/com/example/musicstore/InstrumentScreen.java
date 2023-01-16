package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicstore.adapters.GaleriaInstrumentosAdapter;
import com.example.musicstore.model.Instrument;
import com.example.musicstore.network.ApiClient;
import com.example.musicstore.network.ApiInstrument;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstrumentScreen extends AppCompatActivity {
    ImageView imageView;
    TextView txtTitle;
//    GaleriaInstrumentosAdapter galeriaAdapter;
    Instrument instrument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_screen);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        System.out.println("ESTE ES ID: " + id);

        showInstrument(id+"");


//        ArrayList<Instrument> instruments = new ArrayList<>();
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_01, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_02, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_03, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_04, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_05, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_06, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_07, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_08, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_09, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_01, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_11, "Guitarra eléctrica"));
//        instruments.add(new Instrument("Guitarra", "Guitarra eléctrica", R.drawable.guitarra_12, "Guitarra eléctrica"));
//
//        galeriaAdapter = new GaleriaInstrumentosAdapter(this, instruments);
//        imageView.setImageResource(((Instrument)galeriaAdapter.getItem(position)).getImage());
//        imageView.setImageResource();
//        txtTitle.setText(((Instrument)galeriaAdapter.getItem(position)).getName());

    }

    private void showInstrument(String id) {
        Call<Instrument> call = ApiClient.getClient().create(ApiInstrument.class).getInstrument(id);
        call.enqueue(new Callback<Instrument>() {
            @Override
            public void onResponse(Call<Instrument> call, Response<Instrument> response) {
                if (response.isSuccessful()) {
                    instrument = (Instrument) response.body();
                    System.out.println("Instrument: " + instrument);
                    imageView = findViewById(R.id.instrumentImageDesc);
                    txtTitle = findViewById(R.id.txtInstrumentTitle);
                    TextView txtDescription = findViewById(R.id.txtDescription);
                    txtDescription.setText(instrument.getDescripcion());
                    Picasso.get()
                            .load(instrument.getImagen())
                            .error(R.drawable.ic_launcher_background)
                            .into(imageView);

                    txtTitle.setText(instrument.getModelo());
                }
            }

            @Override
            public void onFailure(Call<Instrument> call, Throwable t) {
                Toast.makeText(InstrumentScreen.this, "Error al cargar el instrumento", Toast.LENGTH_SHORT).show();
            }
        });
    }
}