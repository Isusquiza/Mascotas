package com.llavador.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    private ArrayList<Mascota> favoritas;
    private RecyclerView listaDeMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int numMascotas;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        //Generamos una nueva Action Bar
        Toolbar accionBar = (Toolbar) findViewById(R.id.accionBar);
        setSupportActionBar(accionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Inicializamos las favoritas
        favoritas = new ArrayList<Mascota>();

        //Recogemos los datos de los favoritos
        Bundle parametros = getIntent().getExtras();
        numMascotas = (parametros.size() + 1) / 3;
        for (int i=0; i < numMascotas; i++){
            String txtI = String.valueOf(i);
            Mascota actual = new Mascota(parametros.getString("nombre" + txtI),
                    parametros.getInt("foto" + txtI),
                    parametros.getInt("ratio" + txtI));
            favoritas.add(actual);
        }

        //Inicializa el objeto que ha de mostrar los datos
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);
        LinearLayoutManager llmFavoritas = new LinearLayoutManager(this);
        llmFavoritas.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llmFavoritas);

        //Inicializamos el adaptador y realizamos el bind
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        FavoritasAdaptador adaptador = new FavoritasAdaptador(favoritas);
        listaDeMascotas.setAdapter(adaptador);
    }
}
