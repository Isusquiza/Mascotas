package com.llavador.mascotas.BBDD;

import android.content.ContentValues;
import android.content.Context;

import com.llavador.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by unhugo on 11/12/16.
 */

public class ConstructorFavoritos {
    private Context context;


    public ConstructorFavoritos(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerFavoritos(){
        BBDD bbdd = new BBDD(context);
        ArrayList<Mascota> favoritas = bbdd.obtenerFavoritas();
        return favoritas;
    }

    public void anyadirAFavoritas(Mascota mascota){
        BBDD bbdd = new BBDD(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(KBBDD.TABLA_FAVORITOS_NOMBRE, mascota.getNombre());
        contentValues.put(KBBDD.TABLA_FAVORITOS_FOTO, mascota.getFoto());
        contentValues.put(KBBDD.TABLA_FAVORITOS_RATIO, mascota.getRatio());
        bbdd.anyadirFavorita(contentValues);
    }
}
