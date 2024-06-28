/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.interfaces;

import Persistencia.excepcion.PersistenciaException;
import entidad.Pelicula;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface IPeliculaDAO {
    
    public void agregarPelicula(Pelicula pelicula) throws PersistenciaException;

    public List<Pelicula> obtenerPeliculas() throws PersistenciaException;

    
}
