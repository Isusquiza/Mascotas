package com.llavador.mascotas;

import com.llavador.mascotas.Adaptadores.FavoritasAdaptador;

import java.util.ArrayList;

/**
 * Created by unhugo on 11/12/16.
 */

public interface IFavoritos {
    public void generarLayoutVertical();

    public FavoritasAdaptador favoritasAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecicledView(FavoritasAdaptador adaptador);
}
