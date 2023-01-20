package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.musicstore.Recycler.DataUserBase;
import com.example.musicstore.adapters.customAdapterUsuarios;
import com.example.musicstore.db.Conexion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserGestorActivity extends AppCompatActivity {

    ArrayList<DataUserBase> listUser;
    RecyclerView rvUser;
    Conexion db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_gestor);
        db = new Conexion(this);
        listUser = new ArrayList<>();
        rvUser = findViewById(R.id.rvDatos);
        rvUser.setLayoutManager(new LinearLayoutManager(this));

        EditText filterUser = findViewById(R.id.filterUser);

        consultarListasPersonas();
        customAdapterUsuarios adapter = new customAdapterUsuarios(listUser);
        rvUser.setAdapter(adapter);
        Button btnUpList = findViewById(R.id.btnUpdateList);
        //*************menu
        ImageView ivhome = findViewById(R.id.iconInicio);
        ImageView ivPRoducto = findViewById(R.id.iconProducto);
        ImageView ivCarrito = findViewById(R.id.iconCarrito);
        ImageView ivFaq = findViewById(R.id.iconFaq);

        Intent intentHome = new Intent(this, Inicio.class);
        Intent intentProducto = new Intent(this, InstrumentsGalery.class);
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

        ivFaq.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentFaq);
                    }
                }
        );

        ivCarrito.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentCarrito);
                    }
                }
        );

        //*****************

        filterUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                 ArrayList<DataUserBase> datosFilter = listUser.stream().filter(name->name.getNombre().toLowerCase().contains(charSequence.toString().toLowerCase())).collect(Collectors.toCollection(
                         ArrayList::new
                 ));

                    listUser.clear();
                    customAdapterUsuarios adapter = new customAdapterUsuarios(listUser);
                    rvUser.setAdapter(adapter);
                    consultarListasPersonas();
                    updateList(i1, i2);
                    adapter.updateFilter(datosFilter);

                     //llama a la fncion update debido a que necesitaba que la linea 95 se repita pero directamente no se podia, por ende llamo a una función



                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                adapter.updateFilter(listUser);

            }
        });

//        btnUpList.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onClick(View view) {
//
//
//                listUser.clear();
//                customAdapterUsuarios adapter = new customAdapterUsuarios(listUser);
//                rvUser.setAdapter(adapter);
//                consultarListasPersonas();
//                Toast.makeText(UserGestorActivity.this, "Lista Actualizada", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
    public void updateList(int i1, int i2){
        if(i1 > i2){
            listUser.clear();
            customAdapterUsuarios adapter = new customAdapterUsuarios(listUser);
            rvUser.setAdapter(adapter);
            consultarListasPersonas();
        }
    }

    public void productoIconColor(View view) {
        Button boton = (Button) view;

    }
    private void consultarListasPersonas(){
        SQLiteDatabase dbs = db.getReadableDatabase();
        DataUserBase dataUser = null;
        Cursor cr = dbs.rawQuery("SELECT * FROM usuarios", null);
        while(cr.moveToNext()){
            dataUser = new DataUserBase();
            dataUser.setNombre(cr.getString(1));
            dataUser.setApellido(cr.getString(2));
            dataUser.setUsuario(cr.getString(4));
            dataUser.setId(cr.getString(0));
            listUser.add(dataUser);

        }
        cr.close();
    }
}