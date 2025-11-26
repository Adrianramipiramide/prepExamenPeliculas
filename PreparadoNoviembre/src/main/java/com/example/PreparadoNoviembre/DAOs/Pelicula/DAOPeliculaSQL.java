package com.example.PreparadoNoviembre.DAOs.Pelicula;

import com.example.PreparadoNoviembre.DAOs.DBConnector;
import com.example.PreparadoNoviembre.Entidades.Pelicula;
import com.example.PreparadoNoviembre.PreparadoNoviembreApplication;
import com.example.PreparadoNoviembre.Rest.PeliculaRest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPeliculaSQL implements DAOPelicula{




    @Override
    public List<Pelicula> getListaPeliculas(String nombreUsuario) {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        String consulta = "select * from Pelicula where nombreUsuario like ?";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nombreUsuario);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                int duracion = rs.getInt("duracion");
                listaPeliculas.add(new Pelicula(nombre,duracion,nombreUsuario));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaPeliculas;
    }

    @Override
    public List<Pelicula> insertarPelicula(Pelicula p, String nombreUsuario) {

        String consulta = "insert into Pelicula (nombre,duracion,nombreUsuario) values (?,?,?)";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,p.getNombre());
            statement.setInt(2,p.getDuracion());
            statement.setString(3,nombreUsuario);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
     return getListaPeliculas(nombreUsuario);
    }

    @Override
    public List<Pelicula> actualizarPelicula(String nombrePelicula, Pelicula nuevaPelicula) {

        String consulta = "update Pelicula set nombre = ? where nombre = ?";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nuevaPelicula.getNombre());
            statement.setString(2,nombrePelicula);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return getListaPeliculas(nuevaPelicula.getNombreUsuario());
    }

    @Override
    public void eliminarPelicula(String nombreP) {

        String consulta = "delete from Pelicula where nombre like ?";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nombreP);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
