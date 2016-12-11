package com.llavador.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.llavador.mascotas.Adaptadores.PageAdapter;
import com.llavador.mascotas.Fragments.ListadoMascotas;
import com.llavador.mascotas.Fragments.MiMascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Para los Fragments
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolBar != null){
            setSupportActionBar(toolBar);
            getSupportActionBar().setIcon(R.drawable.ic_huella_gato);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()){
            case R.id.mContacto:
                intent = new Intent(this, Contacto.class);
                break;
            case R.id.mACercaDe:
                intent = new Intent(this, Bio.class);
                break;
            case R.id.mFavoritos:
                intent = new Intent(this, Favoritos.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    // Array de fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ListadoMascotas());
        fragments.add(new MiMascota());

        return fragments;
    }
    // Configuramos la barra de fragments
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil_gato);
    }
}