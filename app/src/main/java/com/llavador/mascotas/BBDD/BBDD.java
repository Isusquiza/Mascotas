package com.llavador.mascotas.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.llavador.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by unhugo on 11/12/16.
 */

public class BBDD extends SQLiteOpenHelper {
    private Context context;

    public BBDD(Context context) {
        super(context, KBBDD.BBDD_NAME, null, KBBDD.BBDD_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + KBBDD.TABLA_FAVORITOS + "(" +
                KBBDD.TABLA_FAVORITOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                KBBDD.TABLA_FAVORITOS_NOMBRE  +   " TEXT, " +
                KBBDD.TABLA_FAVORITOS_FOTO + " INTEGER, " +
                KBBDD.TABLA_FAVORITOS_RATIO + " INTEGER);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + KBBDD.TABLA_FAVORITOS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM " + KBBDD.TABLA_FAVORITOS + " ORDER BY " + KBBDD.TABLA_FAVORITOS_ID + " DESC;";
        SQLiteDatabase bbdd = this.getReadableDatabase();
        Cursor cursor = bbdd.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Mascota mascota = new Mascota(
                    cursor.getString(cursor.getColumnIndex(KBBDD.TABLA_FAVORITOS_NOMBRE)),
                    cursor.getInt(cursor.getColumnIndex(KBBDD.TABLA_FAVORITOS_FOTO)),
                    cursor.getInt(cursor.getColumnIndex(KBBDD.TABLA_FAVORITOS_RATIO)));
            mascotas.add(mascota);
        }
        return mascotas;
    }

    public void anyadirFavorita(ContentValues contentValues){
        // Añadir la favorita al final
        SQLiteDatabase bbdd = this.getWritableDatabase();
        bbdd.insert(KBBDD.TABLA_FAVORITOS, null, contentValues);
        // Comprobamos el número de registros
        String sql = "SELECT * FROM " + KBBDD.TABLA_FAVORITOS + ";";
        Cursor cursor = bbdd.rawQuery(sql, null);

        if (cursor.getCount() > 5){
            // Borrar el último
            sql = "DELETE FROM " + KBBDD.TABLA_FAVORITOS +
                    " WHERE " + KBBDD.TABLA_FAVORITOS_ID + " = " +
                    "(SELECT MIN(" + KBBDD.TABLA_FAVORITOS_ID +
                    ") FROM " + KBBDD.TABLA_FAVORITOS + ");";
            bbdd.execSQL(sql);
        }
        bbdd.close();
    }
}
