package com.example.musicstore.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "MusicStore";
    private static final int DB_VERSION = 1;

    public Conexion(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "" +
                "CREATE TABLE instrumentos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, precio INTEGER, imagen INTEGER, brand TEXT)" +
                "";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("" +
                "DROP TABLE IF EXISTS instrumentos" +
                "");
        onCreate(db);
    }

    public Cursor consultar(String query) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        if(cursor == null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
