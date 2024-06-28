/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.interfaces;

import DTO.ClienteDTO;
import Negocio.excepcion.NegocioException;
import entidad.Cliente;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author jesus
 */
public interface IClienteNegocio {

    public void registrarCliente(ClienteDTO clienteDTO) throws NegocioException;

    public List<ClienteDTO> obtenerClientes() throws NegocioException;

    public Cliente buscarPorCorreo(String correo) throws NegocioException;
    
    public void obtenerClientesPaginados(JTable tabla, int numeroPagina, int tamanoPagina) throws NegocioException;
    
}
