package com.example.PreparadoNoviembre.DAOs.Usuario;

import com.example.PreparadoNoviembre.DAOs.DBConnector;
import com.example.PreparadoNoviembre.Entidades.Pelicula;
import com.example.PreparadoNoviembre.Entidades.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioSQL implements DAOUsuario{
    @Override
    public List<Usuario> getUsers() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String consulta = "select * from Usuario";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                listaUsuarios.add(new Usuario(nombre,edad));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> insertarUsuario(Usuario u) {
        String consulta = "insert into Usuario (nombre,edad) values (?,?)";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,u.getNombre());
            statement.setInt(2,u.getEdad());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return getUsers();
    }

    @Override
    public Usuario actualizarUsuario(String nombre, String nombreNuevo) {
        String consulta = "update Usuario set nombre = ? where nombre = ?";

        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nombreNuevo);
            statement.setString(2,nombre);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> eliminarUser(String nombre) {
        String consulta  = "delete from Usuario where nombre = ?";
        try{
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nombre);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return getUsers();
    }
}
