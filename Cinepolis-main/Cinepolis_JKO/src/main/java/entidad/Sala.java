/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author jesus
 */
public class Sala {
    
     private int idSala;
    private String nombre;
    private int asientosDisponibles;
    private int precioBoleto;
    private int idSucursal;

    public Sala() {
    }

    public Sala(int idSala, String nombre, int asientosDisponibles, int precioBoleto, int idSucursal) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.asientosDisponibles = asientosDisponibles;
        this.precioBoleto = precioBoleto;
        this.idSucursal = idSucursal;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public int getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(int precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
    
}
