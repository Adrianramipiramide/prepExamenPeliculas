package com.example.PreparadoNoviembre.DAOs.Usuario;

import com.example.PreparadoNoviembre.Entidades.Pelicula;
import com.example.PreparadoNoviembre.Entidades.Usuario;

import java.util.List;

public class DAOUsuarioSQL implements DAOUsuario{
    @Override
    public List<Usuario> getUsers() {
        return List.of();
    }

    @Override
    public List<Usuario> insertarUsuario(Usuario u) {
        return List.of();
    }

    @Override
    public Usuario actualizarUsuario(String nombre, List<Pelicula> listaPeliculas) {
        return null;
    }

    @Override
    public Usuario eliminarUser(String nombre) {
        return null;
    }
}
