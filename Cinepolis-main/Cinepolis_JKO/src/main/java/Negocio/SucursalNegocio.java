/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.SucursalDTO;
import Negocio.convertidores.SucursalCVR;
import Negocio.excepcion.NegocioException;
import Persistencia.ConexionBD;
import Persistencia.SucursalDAO;
import Persistencia.excepcion.PersistenciaException;
import Persistencia.interfaces.ISucursalDAO;
import entidad.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author skevi
 */
public class SucursalNegocio {
    
    ISucursalDAO sucursalDAO;
    SucursalCVR sucursalCVR;

    public SucursalNegocio() {
        this.sucursalDAO = new SucursalDAO(new ConexionBD());
        this.sucursalCVR = new SucursalCVR();
    }
    
    
    
    public void llenarCMBX(JComboBox combo) throws NegocioException{
        try{
        for (int i = 0; i < listaSucursalesDTO().size(); i++) {
            combo.addItem(listaSucursalesDTO().get(i));
        }
        }
        catch(NegocioException e){
            throw new NegocioException(e.getMessage());
        }
    }
    
    private List<SucursalDTO> listaSucursalesDTO() throws NegocioException{
        try{
            List<SucursalDTO> listaDTO = new ArrayList<>();
            List<Sucursal> lista = sucursalDAO.obtenerSucursales();
            
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(sucursalCVR.sucursal_SucursalDTO(lista.get(i)));
            }
            return listaDTO;
        }
        catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }
    
}
