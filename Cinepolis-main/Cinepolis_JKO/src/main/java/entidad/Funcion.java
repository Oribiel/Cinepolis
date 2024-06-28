/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class Funcion {
    
    private int idFuncion;
    private Time horaInicio;
    private Time horaFin;
    private LocalDate fecha;
    private int idPelicula;
    private int idSala;

    public Funcion() {
 
    }

    public Funcion(int idFuncion, Time horaInicio, Time horaFin, LocalDate fecha, int idPelicula, int idSala) {
        this.idFuncion = idFuncion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }

    public Funcion(Time horaInicio, Time horaFin, LocalDate fecha, int idPelicula, int idSala) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

