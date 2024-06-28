/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.interfaces;

import Persistencia.excepcion.PersistenciaException;
import entidad.Funcion;

/**
 *
 * @author jesus
 */
public interface IFuncionDAO {
    
    public void agregarFuncion(Funcion funcion) throws PersistenciaException;

    public void eliminarFuncion(int idFuncion) throws PersistenciaException;

    public Funcion obtenerFuncionPorId(int idFuncion) throws PersistenciaException;

    public void actualizarFuncion(Funcion funcion) throws PersistenciaException;
    
}
