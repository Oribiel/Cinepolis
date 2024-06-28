/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


/**
 *
 * @author jesus
 */
public class MensajeDTO {
    
    private int idMensaje;
    private String mensaje;
    private int idSucursal;

    public MensajeDTO() {
    }

    public MensajeDTO(String mensaje, int idSucursal) {
        this.mensaje = mensaje;
        this.idSucursal = idSucursal;
    }

    public MensajeDTO(int idMensaje, String mensaje, int idSucursal) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.idSucursal = idSucursal;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
    
}
