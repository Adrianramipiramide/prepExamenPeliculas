package com.example.PreparadoNoviembre.DAOs.Pelicula;

import com.example.PreparadoNoviembre.Entidades.Pelicula;

import java.util.List;

public class DAOPeliculaSQL implements DAOPelicula{


    @Override
    public List<Pelicula> getListaPeliculas(String nombreUsuario) {
        return List.of();
    }

    @Override
    public List<Pelicula> insertarPelicula(Pelicula p, String nombreUsuario) {
        return List.of();
    }

    @Override
    public List<Pelicula> actualizarPelicula(String nombrePelicula, Pelicula nuevaPelicula) {
        return List.of();
    }

    @Override
    public List<Pelicula> eliminarPelicula(Pelicula p) {
        return List.of();
    }
}
