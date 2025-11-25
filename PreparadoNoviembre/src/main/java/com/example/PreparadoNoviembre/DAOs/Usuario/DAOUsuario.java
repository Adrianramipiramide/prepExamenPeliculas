package com.example.PreparadoNoviembre.DAOs.Usuario;

import com.example.PreparadoNoviembre.Entidades.Pelicula;
import com.example.PreparadoNoviembre.Entidades.Usuario;

import java.util.List;

public interface DAOUsuario {

    List<Usuario> getUsers();
    //Devuelve la lista con todos los users + el nuevo  POST
    List<Usuario> insertarUsuario(Usuario u);
    //Put
    Usuario actualizarUsuario (String nombre,String nombreNuevo);

    List<Usuario> eliminarUser(String nombre);

}
