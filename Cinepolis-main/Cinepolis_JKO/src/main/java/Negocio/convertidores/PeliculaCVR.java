/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.convertidores;

import DTO.PeliculaDTO;
import entidad.Pelicula;

/**
 *
 * @author skevi
 */
public class PeliculaCVR {
    
    public Pelicula peliculaDTO_entidad(PeliculaDTO pelicula){
        int idPelicula = pelicula.getIdPelicula();
        String titulo = pelicula.getTitulo();
        String sinopsis = pelicula.getSinopsis();
        int idPais = pelicula.getIdPais();
        int duracion = pelicula.getDuracion();
        String clasificacion = pelicula.getClasificacion();
        String trailer = pelicula.getTrailer();
        String imagen = pelicula.getImagen();
        int idGenero = pelicula.getIdGenero();
        return new Pelicula (idPelicula, titulo, sinopsis, idPais, duracion, clasificacion, trailer, imagen, idGenero);
    } 
    
    public PeliculaDTO pelicula_DTO(Pelicula peliculaDTO){
        int idPelicula = peliculaDTO.getIdPelicula();
        String titulo = peliculaDTO.getTitulo();
        String sinopsis = peliculaDTO.getSinopsis();
        int idPais = peliculaDTO.getIdPais();
        int duracion = peliculaDTO.getDuracion();
        String clasificacion = peliculaDTO.getClasificacion();
        String trailer = peliculaDTO.getTrailer();
        String imagen = peliculaDTO.getImagen();
        int idGenero = peliculaDTO.getIdGenero();
        return new PeliculaDTO (idPelicula, titulo, sinopsis, idPais, duracion, clasificacion, trailer, imagen, idGenero);
    }
    
}
