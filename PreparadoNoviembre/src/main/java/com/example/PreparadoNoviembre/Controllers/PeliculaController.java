package com.example.PreparadoNoviembre.Controllers;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import com.example.PreparadoNoviembre.Entidades.Pelicula;
import com.example.PreparadoNoviembre.Entidades.Usuario;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {

    @GetMapping("/pelisUser/{usuario}")
    String main(Model model, @PathVariable String usuario){
        System.out.println(usuario);
        model.addAttribute("peliculas", DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(usuario));
        return "ver";
    }

    @GetMapping("/windowNuevaPeli")
    String nueva(Model model){
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "insertarPeli";
    }

    @PostMapping("/insertarPeli")
    String nuevaPeli(Model model,Pelicula p){

        DAOFactory.getInstance().getDaoPelicula().insertarPelicula(p,p.getNombreUsuario());
        model.addAttribute("peliculas",DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(p.getNombreUsuario()));
        return "ver";
    }

    @GetMapping("/windowActualizarPelicula")
    String nuevaPelicula(Model model,String nombre,String nombreUsuario){
        model.addAttribute("nombreUsuario",nombreUsuario);
       model.addAttribute("nombre",nombre);
        return "actualizarPelicula";
    }

    @PostMapping("/actualizarPelicula")
    String actualizarUser(Model model,String nombre, String nuevaPeli,String nombreUsuario){
        System.out.println(nombre);
        DAOFactory.getInstance().getDaoPelicula().actualizarPelicula(nombre,new Pelicula(nuevaPeli,21,nombreUsuario));
        model.addAttribute("usuarios", DAOFactory.getInstance().getDaoUsuario().getUsers());
        return "index";
    }

    @PostMapping("/eliminarPelicula")
    String eliminarPelicula(Model model, String nombre,String nombreUsuario){
        DAOFactory.getInstance().getDaoPelicula().eliminarPelicula(nombre);
        model.addAttribute("peliculas", DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(nombreUsuario));
        return "ver";
    }


}
