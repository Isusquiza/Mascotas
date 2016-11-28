package com.llavador.mascotas;

/**
 * Created by unhugo on 27/11/16.
 */

public class Mascota {
    private String nombre;
    private int foto;
    private int ratio;

    public Mascota(String nombre, int foto, int ratio) {
        this.nombre = nombre;
        this.foto = foto;
        this.ratio = ratio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public String getTextRatio(){
        return String.valueOf(this.ratio);
    }
}
