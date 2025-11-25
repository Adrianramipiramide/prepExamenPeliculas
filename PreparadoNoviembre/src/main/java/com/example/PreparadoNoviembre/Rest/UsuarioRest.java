package com.example.PreparadoNoviembre.Rest;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import com.example.PreparadoNoviembre.Entidades.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRest {

    @PostMapping("/usuarios")
    List<Usuario> insertUser(@RequestBody Usuario u){
        DAOFactory.getInstance().getDaoUsuario().insertarUsuario(u);
        return DAOFactory.getInstance().getDaoUsuario().getUsers();
    }

    @PutMapping("/usuarios/{nombre}")
    Usuario actualizarUser(@PathVariable String nombre, @RequestBody Usuario u){
        DAOFactory.getInstance().getDaoUsuario().actualizarUsuario(nombre,u.getNombre());
        return new Usuario(u.getNombre(),25);
    }

    @DeleteMapping("/usuarios/{nombre}")
    List<Usuario> eliminarUser(@PathVariable String nombre){
        DAOFactory.getInstance().getDaoUsuario().eliminarUser(nombre);
        return DAOFactory.getInstance().getDaoUsuario().getUsers();
    }

}
