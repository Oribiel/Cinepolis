/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.interfaces;

import Persistencia.excepcion.PersistenciaException;
import entidad.Sucursal;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface ISucursalDAO {
    
    
    public void agregarSucursal(Sucursal sucursal) throws PersistenciaException ;
    
    public List<Sucursal> obtenerSucursales() throws PersistenciaException ;
        
    
}
