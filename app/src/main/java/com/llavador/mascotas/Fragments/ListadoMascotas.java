package com.llavador.mascotas.Fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llavador.mascotas.Adaptadores.MascotasAdaptador;
import com.llavador.mascotas.Mascota;
import com.llavador.mascotas.R;

import java.util.ArrayList;

public class ListadoMascotas extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado_mascotas, container, false);

        //Carga de datos
        inicializarMascotas();

        //Inicializa el objeto que ha de mostrar los datos
        listaDeMascotas = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager llmMascotas = new LinearLayoutManager(getActivity());
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llmMascotas);

        //Inicializamos el adaptador y realizamos el bind
        inicializarAdaptador();

        return v;
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Abejita Margarita", R.drawable.a, 3));
        mascotas.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 6));
        mascotas.add(new Mascota("Pececito Javier", R.drawable.c, 2));
        mascotas.add(new Mascota("Vaquita Adelaida", R.drawable.d, 8));
        mascotas.add(new Mascota("Zorrito Juan", R.drawable.e, 6));
        mascotas.add(new Mascota("Caballito Tomás", R.drawable.f, 1));
        mascotas.add(new Mascota("Caracol Andrés", R.drawable.g, 2));
    }

    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this.getActivity());
        listaDeMascotas.setAdapter(adaptador);
    }
}
