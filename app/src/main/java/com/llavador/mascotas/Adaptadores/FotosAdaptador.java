package com.llavador.mascotas.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.llavador.mascotas.Mascota;
import com.llavador.mascotas.R;

import java.util.ArrayList;

/**
 * Created by unhugo on 5/12/16.
 */

public class FotosAdaptador extends RecyclerView.Adapter<FotosAdaptador.fotosViewHolder> {
    ArrayList<Mascota> fotos;

    public FotosAdaptador(ArrayList<Mascota> fotos){
        this.fotos = fotos;
    }

    @Override
    public void onBindViewHolder(final FotosAdaptador.fotosViewHolder holder, final int position) {
        final Mascota foto = fotos.get(position);
        holder.ivFotoFoto.setImageResource(foto.getFoto());
        holder.tvNumeroFoto.setText(foto.getTextRatio());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    @Override
    public FotosAdaptador.fotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);

        return new FotosAdaptador.fotosViewHolder(v);
    }

    public static class fotosViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFotoFoto;
        private TextView tvNumeroFoto;


        public fotosViewHolder(View itemView) {
            super(itemView);
            ivFotoFoto = (ImageView) itemView.findViewById(R.id.ivFotoFoto);
            tvNumeroFoto = (TextView) itemView.findViewById(R.id.tvNumeroFoto);
        }
    }
}
