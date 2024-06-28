/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.interfaces;

import Negocio.excepcion.NegocioException;
import Persistencia.PeliculaDAO;
import Persistencia.excepcion.PersistenciaException;
import entidad.Pelicula;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface IPeliculaNegocio {
      
    
    public List<Pelicula> obtenerPeliculas() throws NegocioException, PersistenciaException;
}
