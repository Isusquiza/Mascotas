package com.llavador.mascotas.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llavador.mascotas.Adaptadores.FotosAdaptador;
import com.llavador.mascotas.Adaptadores.MascotasAdaptador;
import com.llavador.mascotas.Mascota;
import com.llavador.mascotas.R;

import java.util.ArrayList;

public class MiMascota extends Fragment {
    ArrayList<Mascota> fotos;
    private RecyclerView rvFotos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        //Carga de datos
        inicializarLista();

        //Inicializa el objeto que ha de mostrar los datos
        rvFotos = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glmFotos = new GridLayoutManager(getActivity(), 3);
        rvFotos.setLayoutManager(glmFotos);

        //Inicializamos el adaptador y realizamos el bind
        inicializarAdaptador();

        return v;
    }

    public void inicializarLista(){
        fotos = new ArrayList<Mascota>();

        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 6));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 8));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 3));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 4));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 6));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 1));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 2));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 8));
        fotos.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 4));
    }

    public void inicializarAdaptador(){
        FotosAdaptador adaptador = new FotosAdaptador(fotos);
        rvFotos.setAdapter(adaptador);
    }

}
