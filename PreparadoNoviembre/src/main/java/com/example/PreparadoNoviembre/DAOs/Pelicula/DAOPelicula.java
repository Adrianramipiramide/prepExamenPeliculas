package com.example.PreparadoNoviembre.DAOs.Pelicula;

import com.example.PreparadoNoviembre.Entidades.Pelicula;

import java.util.List;

public interface DAOPelicula {

    List<Pelicula> getListaPeliculas(String nombreUsuario);

    List<Pelicula> insertarPelicula(Pelicula p,String nombreUsuario);

    List<Pelicula> actualizarPelicula(String nombrePelicula, Pelicula nuevaPelicula);

    void eliminarPelicula(String nombreP);

}
