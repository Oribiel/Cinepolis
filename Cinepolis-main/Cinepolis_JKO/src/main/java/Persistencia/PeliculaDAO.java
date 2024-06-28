/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.interfaces.IConexionBD;
import Persistencia.excepcion.PersistenciaException;
import Persistencia.interfaces.IPeliculaDAO;
import entidad.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculaDAO implements IPeliculaDAO {

    private IConexionBD conexionBD;

    public PeliculaDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) throws PersistenciaException {
        String query = "INSERT INTO Pelicula (Titulo, ID_Genero, ID_Pais) VALUES (?, ?, ?)";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pelicula.getTitulo());
            stmt.setInt(2, pelicula.getIdGenero());
            stmt.setInt(3, pelicula.getIdPais());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Pelicula> obtenerPeliculas() throws PersistenciaException {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT ID_Pelicula, Titulo, Sinopsis, ID_Pais, Duracion, Clasificacion, Trailer, Imagen, ID_Genero FROM Pelicula";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("ID_Pelicula"));
                pelicula.setTitulo(rs.getString("Titulo"));
                pelicula.setSinopsis(rs.getString("Sinopsis"));
                pelicula.setIdPais(rs.getInt("ID_Pais"));
                pelicula.setDuracion(rs.getInt("Duracion"));
                pelicula.setClasificacion(rs.getString("Clasificacion"));
                pelicula.setTrailer(rs.getString("Trailer"));
                pelicula.setImagen(rs.getString("Imagen"));
                pelicula.setIdGenero(rs.getInt("ID_Genero"));
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener clientes de la base de datos: " + ex.getMessage());
        }
        return peliculas;
    }

}
