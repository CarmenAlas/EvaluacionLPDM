package com.example.evaluacionlpdm.Clases;

import com.example.evaluacionlpdm.Interfaces.Prestable;


public class Libro extends Publicacion implements Prestable {
    private boolean estadoPrestamo = false;

    public Libro(){}

    public Libro(int codigoPublicacion, String tituloPublicacion,
                 int anioPublicacion, boolean estadoPrestamo) {
        super(codigoPublicacion, tituloPublicacion, anioPublicacion);
        this.estadoPrestamo = estadoPrestamo;
    }

    @Override
    public int getTipoPublicacion(){return 1;}

    @Override
    public void prestar() {
        this.estadoPrestamo = true;
    }

    @Override
    public void devolver() {
        this.estadoPrestamo = false;
    }

    @Override
    public boolean prestado() {
        return this.estadoPrestamo;
    }

    @Override
    public String toString() {
        return getCodigoPublicacion() + " " + getTituloPublicacion() + " " + getAnioPublicacion() + " " + estadoPrestamo;
    }
}