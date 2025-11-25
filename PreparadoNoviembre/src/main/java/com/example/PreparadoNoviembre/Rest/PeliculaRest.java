package com.example.PreparadoNoviembre.Rest;

import com.example.PreparadoNoviembre.DAOs.DAOFactory;
import com.example.PreparadoNoviembre.Entidades.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class PeliculaRest {

    @GetMapping("/usuario/{nombreUsuario}/peliculas")
    List<Pelicula> getPeliculas(@PathVariable String nombreUsuario){

        return DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(nombreUsuario);
    }

    @PostMapping("/usuario/{nombreUsuario}/peliculas")
    List<Pelicula> insertPelicula(@RequestBody Pelicula p,@PathVariable String nombreUsuario){
        DAOFactory.getInstance().getDaoPelicula().insertarPelicula(p,nombreUsuario);
        return DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(nombreUsuario);
    }

    @PutMapping("usuarios/{nombreUsuario}/pelicula/{nombre}")
    List<Pelicula> actualizarPelicual(@PathVariable String nombreUsuario, @PathVariable String nombre, @RequestBody Pelicula nuevaPeli){

        DAOFactory.getInstance().getDaoPelicula().actualizarPelicula(nombre,nuevaPeli);

        return DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(nombreUsuario);
    }

    @DeleteMapping("usuarios/{nombreUsuario}/pelicula/{nombre}")
    List<Pelicula> eliminarPelicula(@PathVariable String nombreUsuario, @PathVariable String nombre){
        DAOFactory.getInstance().getDaoPelicula().eliminarPelicula(nombre);
        return DAOFactory.getInstance().getDaoPelicula().getListaPeliculas(nombreUsuario);
    }


}
