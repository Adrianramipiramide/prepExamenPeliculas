package com.example.PreparadoNoviembre.Controllers;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PeliculaController {

    @GetMapping("/pelisUser/{usuario}")
    String main(Model model, @PathVariable String usuario){
        System.out.println(usuario);
        model.addAttribute("peliculas", DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(usuario));
        return "ver";
    }


}
