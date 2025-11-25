package com.example.PreparadoNoviembre.Controllers;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeliculaController {

    @GetMapping("/")
    String main(Model model){
        model.addAttribute("peliculas", DAOFactory.getInstance().getDaoPelicula().getListaPeliculas("Jorge"));
        return "index";
    }


}
