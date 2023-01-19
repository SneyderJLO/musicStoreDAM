package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.musicstore.adapters.GaleriaInstrumentosAdapter;
import com.example.musicstore.db.Conexion;
import com.example.musicstore.model.Instrument;
import com.example.musicstore.network.ApiClient;
import com.example.musicstore.network.ApiInstrument;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstrumentsGalery extends AppCompatActivity {
    GridView gridView;
    Conexion cx;
    ArrayList<Instrument> instrumentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments_galery);
        ImageView ivhome = findViewById(R.id.iconInicio);
        ImageView ivUsuario = findViewById(R.id.iconUsuario);
        //ImageView billi
        //ImageView pradin
        ImageView ivFaq = findViewById(R.id.iconFaq);

        Intent intentHome = new Intent(this, Inicio.class);
        Intent intentUsuario = new Intent(this, UserGestorActivity.class);
        //intent billy
        // intent pradin
        Intent intentFaq = new Intent(this, FaqActivity.class);

        ivhome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentHome);
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
        showInstruments();


//        cx = new Conexion(this);
//        instrumentList = new ArrayList<>();

//        prepararDatos();

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


//        gridView = findViewById(R.id.gridInstruments);
//        gridView.setAdapter(new GaleriaInstrumentosAdapter(this, instruments));
//        gridView.setNumColumns(2);
//
//        gridView.setOnItemClickListener((parent, view, position, id) -> {
//            Intent intent = new Intent(this, InstrumentScreen.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//        });
    }

    private void showInstruments() {
        Call<List<Instrument>> call = ApiClient.getClient().create(ApiInstrument.class).getInstruments();
        call.enqueue(new Callback<List<Instrument>>() {
            @Override
            public void onResponse(Call<List<Instrument>> call, Response<List<Instrument>> response) {
                if (response.isSuccessful()) {
//                    System.out.println("Response: " + response.body());
                    instrumentList = (ArrayList<Instrument>) response.body();
//                    System.out.println("Instrumentos: " + instrumentList);
                    gridView = findViewById(R.id.gridInstruments);
                    gridView.setAdapter(new GaleriaInstrumentosAdapter(InstrumentsGalery.this, instrumentList));
                    gridView.setNumColumns(2);

                    gridView.setOnItemClickListener((parent, view, position, id) -> {
                        Intent intent = new Intent(InstrumentsGalery.this, InstrumentScreen.class);
                        intent.putExtra("id", instrumentList.get(position).getId());
                        startActivity(intent);
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Instrument>> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
                Toast.makeText(InstrumentsGalery.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    void prepararDatos () {
//        Cursor cursor = cx.consultar("SELECT * FROM instrumentos");
//        if(cursor.getCount() != 0){
//            while (cursor.moveToNext()){
//                String nombre = cursor.getString(1);
//                String descripcion = cursor.getString(2);
//                String imagen = cursor.getInt(4);
//                String brand = cursor.getString(5);
//                Instrument instrument = new Instrument(nombre, descripcion, imagen, brand);
//                instrumentList.add(instrument);
//            }
//        }
//    }
}