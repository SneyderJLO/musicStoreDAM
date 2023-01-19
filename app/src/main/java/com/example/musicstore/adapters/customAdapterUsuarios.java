package com.example.musicstore.adapters;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;
import com.example.musicstore.Recycler.DataUserBase;
import com.example.musicstore.db.Conexion;

import java.util.ArrayList;

public class customAdapterUsuarios extends RecyclerView.Adapter<customAdapterUsuarios.VHUsuarios> {
    public customAdapterUsuarios(@NonNull ArrayList<DataUserBase> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    @NonNull
    ArrayList<DataUserBase> listUsuarios;


    @Override
    public VHUsuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuariosrecycler, null, false);
        return new VHUsuarios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHUsuarios holder, int position) {
        holder.nombre.setText(listUsuarios.get(position).getNombre());
        holder.apellido.setText(listUsuarios.get(position).getApellido());
        holder.nickName.setText(listUsuarios.get(position).getUsuario());
    }

    @Override
    public int getItemCount() {
        return listUsuarios.size();

    }

    public void updateFilter(@NonNull ArrayList<DataUserBase> listUsuarios){
        this.listUsuarios =  listUsuarios;
        notifyDataSetChanged();

    }

    public class VHUsuarios extends RecyclerView.ViewHolder {
        TextView nombre, apellido, nickName;


        public VHUsuarios(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombreBd);
            apellido = itemView.findViewById(R.id.tvApellido);
            nickName = itemView.findViewById(R.id.tvdataNickName);
            ImageView btnEdit = itemView.findViewById(R.id.btnEdit);
            ImageView btnDelete = itemView.findViewById(R.id.btnDelete);
            Conexion dbHelper = new Conexion(itemView.getContext());
            final SQLiteDatabase db = dbHelper.getReadableDatabase();


            btnDelete.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View view) {
                    int posRv = getAdapterPosition();
                    DataUserBase pos = listUsuarios.get(posRv);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    int idValue = Integer.parseInt(pos.getId());
                    String whereClause = "id = ?";
                    String[] whereArgs = new String[] { String.valueOf(idValue) };
                    db.delete("usuarios", whereClause, whereArgs);

                    Toast.makeText(itemView.getContext(), "Usuario Eliminado", Toast.LENGTH_SHORT).show();

                    listUsuarios.remove(posRv);
                    notifyDataSetChanged();

                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("Range")
                @Override
                public void onClick(View view) {
                    View customForm = LayoutInflater.from(itemView.getContext()).inflate(R.layout.cutomeruser, null);
                    AlertDialog.Builder customDialog = new AlertDialog.Builder(itemView.getContext());
                    customDialog.setView(customForm);
                    AlertDialog dialog = customDialog.create();
                    EditText etNombre = customForm.findViewById(R.id.etNombreCust);
                    EditText etApellido = customForm.findViewById(R.id.etApellidoCust);
                    EditText etEmail = customForm.findViewById(R.id.etCorreoCust);
                    EditText etDireccion = customForm.findViewById(R.id.etDireccionCust);
                    EditText etContrasenia = customForm.findViewById(R.id.etPassCust);
                    EditText etNick = customForm.findViewById(R.id.etNickCust);
                    Button btnActualizar = customForm.findViewById(R.id.btnUpdatCust);

                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                    int posRv = getAdapterPosition();
                    DataUserBase pos = listUsuarios.get(posRv);

                    Log.d("datospos", String.valueOf(pos.getId()));

                    //getide↓



                    if(db !=null){

                        try {
                            int idVal = Integer.parseInt(pos.getId());
                            Cursor select = db.rawQuery("SELECT id, nombre, apellido, email, usuario, contrasenia, direccion FROM usuarios WHERE id ="+idVal, null);
                            if( select !=null){
                                select.moveToFirst();
                                etNombre.setText(select.getString(select.getColumnIndex("nombre")));
                                etApellido.setText(select.getString(select.getColumnIndex("apellido")));
                                etEmail.setText(select.getString(select.getColumnIndex("email")));
                                etNick.setText(select.getString(select.getColumnIndex("usuario")));
                                etContrasenia.setText(select.getString(select.getColumnIndex("contrasenia")));
                                etDireccion.setText(select.getString(select.getColumnIndex("direccion")));

                                //ACTUALIZAR bd↓
                                btnActualizar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                                        ContentValues values = new ContentValues();
                                        values.put("nombre",etNombre.getText().toString());
                                        values.put("apellido", etApellido.getText().toString());
                                        values.put("email", etEmail.getText().toString());
                                        values.put("usuario", etNick.getText().toString());
                                        values.put("contrasenia", etContrasenia.getText().toString());
                                        values.put("direccion", etDireccion.getText().toString());
                                        String whereClause = "id = ?";
                                        String[] whereArgs = new String[] { String.valueOf(idVal) };
                                        db.update("usuarios", values, whereClause, whereArgs);

                                        dialog.dismiss();
                                        try {
                                            Cursor select = db.rawQuery("SELECT id, nombre, apellido, usuario FROM usuarios WHERE id="+idVal, null);
                                            if( select !=null){

                                                select.moveToFirst();
                                                nombre.setText(select.getString(select.getColumnIndex("nombre")));
                                                apellido.setText(select.getString(select.getColumnIndex("apellido")));
                                            }
                                            select.close();
                                        }catch (Exception ignored){

                                        }

                                    }
                                });
                                //↑
                            }


                            select.close();
//                    db.close();
                        }catch (Exception e){
                            Toast.makeText(itemView.getContext(), "error", Toast.LENGTH_SHORT).show();

                        }

                    }
                }
            });

        }

    }
}
