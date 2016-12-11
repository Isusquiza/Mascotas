package com.llavador.mascotas.Adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.llavador.mascotas.BBDD.ConstructorFavoritos;
import com.llavador.mascotas.Mascota;
import com.llavador.mascotas.R;

import java.util.ArrayList;

/**
 * Created by unhugo on 27/11/16.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.mascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);

        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final mascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvNumero.setText(mascota.getTextRatio());

        holder.ibFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorFavoritos constructorFavoritos = new ConstructorFavoritos(activity);
                constructorFavoritos.anyadirAFavoritas(mascota);
                mascota.setRatio(mascota.getRatio() + 1);
                bindViewHolder(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoto;
        private ImageButton ibFavorito;
        private TextView tvNombre;
        private TextView tvNumero;


        public mascotaViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            ibFavorito = (ImageButton) itemView.findViewById(R.id.ibFavorito);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);
        }
    }
}
