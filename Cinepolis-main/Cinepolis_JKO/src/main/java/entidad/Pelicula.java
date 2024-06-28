/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author jesus
 */
public class Pelicula {
     private int idPelicula;
    private String titulo;
    private String sinopsis;
    private int idPais;
    private int duracion;
    private String clasificacion;
    private String trailer;
    private String imagen;
    private int idGenero;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, String sinopsis, int idPais, int duracion, String clasificacion, String trailer, String imagen, int idGenero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.idPais = idPais;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.trailer = trailer;
        this.imagen = imagen;
        this.idGenero = idGenero;
    }

    public Pelicula(String titulo, String sinopsis, int idPais, int duracion, String clasificacion, String trailer, String imagen, int idGenero) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.idPais = idPais;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.trailer = trailer;
        this.imagen = imagen;
        this.idGenero = idGenero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    
    
}
