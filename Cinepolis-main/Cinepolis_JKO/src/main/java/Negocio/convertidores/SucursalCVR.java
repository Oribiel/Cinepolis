/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.convertidores;

import DTO.SucursalDTO;
import entidad.Sucursal;

/**
 *
 * @author skevi
 */
public class SucursalCVR {
    
    public Sucursal SucursalDTO_entidad(SucursalDTO sucursalDTO){
        int idSucursal = sucursalDTO.getIdSucursal();
        String nombre = sucursalDTO.getNombre();
        Double latitud = sucursalDTO.getLatitud();
        Double longitud = sucursalDTO.getLongitud();
        Integer srid = sucursalDTO.getSrid();
        String ciudad = sucursalDTO.getCiudad();
        String colonia = sucursalDTO.getColonia();
        String calle = sucursalDTO.getCalle();
        String numero = sucursalDTO.getNumero();
        return new Sucursal(idSucursal, nombre, latitud, longitud, srid, ciudad,
        colonia, calle, numero);
    }
    
    public SucursalDTO sucursal_SucursalDTO(Sucursal sucursal){
        int idSucursal = sucursal.getIdSucursal();
        String nombre = sucursal.getNombre();
        Double latitud = sucursal.getLatitud();
        Double longitud = sucursal.getLongitud();
        Integer srid = sucursal.getSrid();
        String ciudad = sucursal.getCiudad();
        String colonia = sucursal.getColonia();
        String calle = sucursal.getCalle();
        String numero = sucursal.getNumero();
        return new SucursalDTO(idSucursal, nombre, latitud, longitud, srid, ciudad,
        colonia, calle, numero);
    }
    
}
