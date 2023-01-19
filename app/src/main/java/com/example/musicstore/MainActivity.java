package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicstore.db.Conexion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btnregis = findViewById(R.id.btnRegister);
        EditText etUser = findViewById(R.id.etUser);
        EditText etPass = findViewById(R.id.etPass);
        Button btnIngresar = findViewById(R.id.btnIngresar);
        Intent intenRegister = new  Intent(MainActivity.this, RegisterActivity.class);
        Intent intentPrincipal = new Intent(this, UserGestorActivity.class);


        //sharedkeepSession

        SharedPreferences spIsLogin = getSharedPreferences("prefLogin", MODE_PRIVATE);
        boolean isLogin = spIsLogin.getBoolean("isloginValue", false);
        //↑

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentPrincipal);
            }
        });

        //creamos el enlace con nuestra base de datos para poder hacer el SELECT
        Conexion dbHelper = new Conexion(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(db !=null){
                    try {
                        String user = etUser.getText().toString().trim();
                        String contrasenia = etPass.getText().toString().trim();
                        //CREAMOS UN SELECT para verificar la existencia del usuario
                        Cursor select = db.rawQuery("SELECT usuario, contrasenia FROM usuarios WHERE usuario= '" + user + "'"+ "AND contrasenia ='"+contrasenia+"'", null);
                        if(select.getCount()>=1){
                            dialogPass(isLogin);
                            Toast.makeText(MainActivity.this, "Credenciales Correctas", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                        }
                        select.close();
                    }catch (Exception e ){
//                    Toast.makeText(MainActivity.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        if(isLogin){
            startActivity(intentPrincipal);
        }
    }

    private void dialogPass(boolean isLogin){
        View customDialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialogkeepsession, null);
        // Creamos un nuevo diálogo
        AlertDialog.Builder customDialog = new AlertDialog.Builder(MainActivity.this);

        customDialog.setView(customDialogView);
        Button noBtn = customDialogView.findViewById(R.id.btnNegative);
        Button siBtn = customDialogView.findViewById(R.id.btnPositive);
        AlertDialog dialog = customDialog.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        Intent intentPrincipal = new Intent(this, InstrumentsGalery.class);

        //Sp
        SharedPreferences spIsLogin = getSharedPreferences("prefLogin", MODE_PRIVATE);
        SharedPreferences.Editor editorisLogin =spIsLogin.edit();

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorisLogin.putBoolean("isloginValue", false);
                editorisLogin.apply();
                startActivity(intentPrincipal);

            }
        });

        siBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //spisLogin
                editorisLogin.putBoolean("isloginValue", true);
                editorisLogin.apply();
                //↑

                startActivity(intentPrincipal);
            }
        });

    }

//    public void onLogin (View view) {
//        Intent intent = new Intent(this, InstrumentsGalery.class);
//        startActivity(intent);
//    }
}