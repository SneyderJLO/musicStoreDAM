package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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
//                    listUser.clear();
//                    consultarListasPersonas();
//                    customAdapterUsuarios adapter = new customAdapterUsuarios(listUser);
//                    rvUser.setAdapter(adapter);
                    adapter.updateFilter(datosFilter);
                    Log.d("datosOrg", listUser.toString());
                    Log.d("datosNew", datosFilter.toString());


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                adapter.updateFilter(listUser);

            }
        });

        btnUpList.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {



                rvUser.setAdapter(adapter);
                listUser.clear();
                consultarListasPersonas();
                Toast.makeText(UserGestorActivity.this, "Lista Actualizada", Toast.LENGTH_SHORT).show();

            }
        });

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