package com.example.PreparadoNoviembre.Controllers;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @GetMapping("/")
    String getUsers(Model model){
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "index";
    }
}
