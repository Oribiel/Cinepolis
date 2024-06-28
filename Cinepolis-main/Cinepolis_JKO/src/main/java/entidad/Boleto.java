/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class Boleto {

    private int idBoleto;
    private LocalDate fechaCompra;
    private boolean estado;
    private int idCliente;
    private int idFuncion;

    public Boleto() {
    }

    public Boleto(int idBoleto, LocalDate fechaCompra, boolean estado, int idCliente, int idFuncion) {
        this.idBoleto = idBoleto;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idFuncion = idFuncion;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }
    
    

}
