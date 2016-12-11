package com.llavador.mascotas.Presentador;

import android.content.Context;

import com.llavador.mascotas.BBDD.ConstructorFavoritos;
import com.llavador.mascotas.IFavoritos;
import com.llavador.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by unhugo on 11/12/16.
 */

public class RecliclerViewPresentador implements IRecliclerViewPresentador {
    private IFavoritos iFavoritos;
    private Context context;
    private ArrayList<Mascota> favoritas;
    private ConstructorFavoritos constructorFavoritos;

    public RecliclerViewPresentador(IFavoritos iFavoritos, Context context) {
        this.iFavoritos = iFavoritos;
        this.context = context;

        this.obtenerFavoritosBBDD();
    }

    /*public ArrayList<Mascota> prueba(){
        constructorFavoritos = new ConstructorFavoritos(context);
        favoritas = constructorFavoritos.obtenerFavoritos();
        return favoritas;
    }*/

    @Override
    public void obtenerFavoritosBBDD() {
        constructorFavoritos = new ConstructorFavoritos(context);
        favoritas = constructorFavoritos.obtenerFavoritos();
        this.mostrarFavoritosRecliclerView();
    }

    @Override
    public void mostrarFavoritosRecliclerView() {
        iFavoritos.inicializarAdaptadorRecicledView(iFavoritos.favoritasAdaptador(favoritas));
        iFavoritos.generarLayoutVertical();
    }
}
