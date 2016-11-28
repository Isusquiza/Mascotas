package com.llavador.mascotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by unhugo on 28/11/16.
 */

public class FavoritasAdaptador extends RecyclerView.Adapter<FavoritasAdaptador.favoritasViewHolder>{
    ArrayList<Mascota> favoritas;

    public FavoritasAdaptador(ArrayList<Mascota> favoritas) {
        this.favoritas = favoritas;
    }

    @Override
    public FavoritasAdaptador.favoritasViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);

        return new FavoritasAdaptador.favoritasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FavoritasAdaptador.favoritasViewHolder holder, final int position) {
        final Mascota favorita = favoritas.get(position);
        holder.ivFoto.setImageResource(favorita.getFoto());
        holder.tvNombre.setText(favorita.getNombre());
        holder.tvNumero.setText(favorita.getTextRatio());
    }

    @Override
    public int getItemCount() {
        return favoritas.size();
    }

    public static class favoritasViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvNumero;


        public favoritasViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);
        }
    }
}
