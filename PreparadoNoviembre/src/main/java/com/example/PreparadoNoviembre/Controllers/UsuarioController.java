package com.example.PreparadoNoviembre.Controllers;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import com.example.PreparadoNoviembre.Entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @GetMapping("/")
    String getUsers(Model model){
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "index";
    }
//sin terminar
    @GetMapping("/windowInsertarUser")
    String insertar(Model model){
        model.addAttribute("usuarios",DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "insertarUser";
    }

    @PostMapping("/insertarUsuario")
    String insertUser(Model model, Usuario u){
        DAOFactory.getInstance().getDaoUsuario().insertarUsuario(u);
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "index";
    }
    @GetMapping("/windowEliminarUser")
    String eliminar(Model model){
        model.addAttribute("usuarios",DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "eliminarUsuario";
    }

    @PostMapping("/eliminarUser")
    String eliminarUser(String nombre, Model model){
        System.out.println(nombre);
        DAOFactory.getInstance().getDaoUsuario().eliminarUser(nombre);
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "index";
    }
}
