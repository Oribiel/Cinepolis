/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class FuncionDTO {
    
    private int idFuncion;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    private LocalDate fecha;
    private Time limpieza;
    private int idPelicula;
    private int idSala;

    public FuncionDTO() {
    }

    
    public FuncionDTO(LocalDate horaInicio, LocalDate horaFin, LocalDate fecha, Time limpieza, int idPelicula, int idSala) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.limpieza = limpieza;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }

 
    public FuncionDTO(int idFuncion, LocalDate horaInicio, LocalDate horaFin, LocalDate fecha, Time limpieza, int idPelicula, int idSala) {
        this.idFuncion = idFuncion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.limpieza = limpieza;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDate horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(Time limpieza) {
        this.limpieza = limpieza;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    
    
    
}
