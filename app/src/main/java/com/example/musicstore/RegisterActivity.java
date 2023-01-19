package com.example.musicstore;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.musicstore.db.Conexion;

public class RegisterActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmregister);

        EditText nombre = findViewById(R.id.etNombre);
        EditText apellido = findViewById(R.id.etApellido);
        EditText usuario = findViewById(R.id.etUsuario);
        EditText correo = findViewById(R.id.etCorreo);
        EditText contrasena = findViewById(R.id.etContraseña);
        EditText direccion = findViewById(R.id.etDireccion);
        Button btnRegistrar = findViewById(R.id.btnRegistrarUser);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.getText().toString().isEmpty()||
                        nombre.getText().toString().isEmpty()||
                        apellido.getText().toString().isEmpty()||
                        usuario.getText().toString().isEmpty()||
                        correo.getText().toString().isEmpty()||
                        contrasena.getText().toString().isEmpty()||
                        direccion.getText().toString().isEmpty()

                ){
                    Toast.makeText(RegisterActivity.this, "Rellene los campos", Toast.LENGTH_SHORT).show();

                }else{
                    Conexion conexion = new Conexion(RegisterActivity.this);
                    final SQLiteDatabase db = conexion.getWritableDatabase();
                    if(db !=null){
                        ContentValues cv = new ContentValues();

                        cv.put("nombre", nombre.getText().toString().trim());
                        cv.put("apellido", apellido.getText().toString().trim());
                        cv.put("usuario", usuario.getText().toString().trim());
                        cv.put("email", correo.getText().toString().trim());
                        cv.put("contrasenia", contrasena.getText().toString().trim());
                        cv.put("direccion", direccion.getText().toString().trim());
                        db.insert("usuarios", null, cv);
                        Toast.makeText(RegisterActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Error en el registro", Toast.LENGTH_SHORT).show();
                    }
                    nombre.setText("");
                    apellido.setText("");
                    usuario.setText("");
                    direccion.setText("");
                    correo.setText("");
                    contrasena.setText("");


                }
            }
        });
    }
}
