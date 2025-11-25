package com.example.PreparadoNoviembre.DAOs;

import com.example.PreparadoNoviembre.DAOs.Pelicula.DAOPelicula;
import com.example.PreparadoNoviembre.DAOs.Pelicula.DAOPeliculaSQL;
import com.example.PreparadoNoviembre.DAOs.Usuario.DAOUsuario;
import com.example.PreparadoNoviembre.DAOs.Usuario.DAOUsuarioSQL;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOPelicula daoPelicula;
    private DAOUsuario daoUsuario;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPelicula getDaoPartida(){
        if (this.daoPelicula == null){
            daoPelicula = new DAOPeliculaSQL();
        }
        return daoPelicula;
    }

    public DAOUsuario getDaoUsuario() {
        if (this.daoUsuario == null) {
            this.daoUsuario = new DAOUsuarioSQL();
        }
        return daoUsuario;
    }

}