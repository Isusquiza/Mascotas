package com.llavador.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritas;
    private RecyclerView listaDeMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generamos una nueva Action Bar
        Toolbar accionBar = (Toolbar) findViewById(R.id.accionBar);
        setSupportActionBar(accionBar);

        //Carga de datos
        inicializarLista();

        //Inicializa el objeto que ha de mostrar los datos
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llmMascotas);

        //Inicializamos el adaptador y realizamos el bind
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.favoritos:
                if (favoritas.size() > 0){
                    int i = 0;
                    Intent intent = new Intent(this, Favoritos.class);
                    for (Mascota mascota : favoritas) {
                        intent.putExtra("nombre" + String.valueOf(i), mascota.getNombre());
                        intent.putExtra("foto" + String.valueOf(i), mascota.getFoto());
                        intent.putExtra("ratio" + String.valueOf(i), mascota.getRatio());
                        i++;
                    }
                    this.startActivity(intent);
                } else {
                    Toast.makeText(this, getString(R.string.main_no_favoritos), Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        favoritas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Abejita Margarita", R.drawable.a, 3));
        mascotas.add(new Mascota("Tortuguita Yolanda", R.drawable.b, 6));
        mascotas.add(new Mascota("Pececito Javier", R.drawable.c, 2));
        mascotas.add(new Mascota("Vaquita Adelaida", R.drawable.d, 8));
        mascotas.add(new Mascota("Zorrito Juan", R.drawable.e, 6));
        mascotas.add(new Mascota("Caballito Tomás", R.drawable.f, 1));
        mascotas.add(new Mascota("Caracol Andrés", R.drawable.g, 2));
    }

    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, favoritas);
        listaDeMascotas.setAdapter(adaptador);
    }
}