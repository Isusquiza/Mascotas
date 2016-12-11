package com.llavador.mascotas;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.llavador.mascotas.Adaptadores.FavoritasAdaptador;
import com.llavador.mascotas.Presentador.IRecliclerViewPresentador;
import com.llavador.mascotas.Presentador.RecliclerViewPresentador;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity implements IFavoritos{
    private ArrayList<Mascota> favoritas;
    private RecyclerView listaDeMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        favoritas = new ArrayList<>();
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);
        RecliclerViewPresentador presentador = new RecliclerViewPresentador(this, this);
        // Toast.makeText(this, String.valueOf(presentador.prueba().size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llmFavoritas = new LinearLayoutManager(this);
        llmFavoritas.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llmFavoritas);
    }

    @Override
    public FavoritasAdaptador favoritasAdaptador(ArrayList<Mascota> mascotas) {
        FavoritasAdaptador adaptador = new FavoritasAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecicledView(FavoritasAdaptador adaptador) {
        listaDeMascotas.setAdapter(adaptador);
    }
}
