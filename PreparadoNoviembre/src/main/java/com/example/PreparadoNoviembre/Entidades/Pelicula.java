package com.example.PreparadoNoviembre.Entidades;

public class Pelicula {
    String nombre;
    int duracion;
    String nombreUsuario;

    public Pelicula(String nombre, int duracion, String nombreUsuario) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.nombreUsuario = nombreUsuario;
    }
    public Pelicula(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
