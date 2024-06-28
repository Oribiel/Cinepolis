/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.interfaces.IFuncionDAO;
import Persistencia.interfaces.IConexionBD;
import Persistencia.excepcion.PersistenciaException;
import entidad.Funcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class FuncionesDAO implements IFuncionDAO{

    private IConexionBD conexionBD;

    public FuncionesDAO() {
    }

    public FuncionesDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarFuncion(Funcion funcion) throws PersistenciaException {
        String query = "INSERT INTO Funcion (HoraInicio, HoraFin, Fecha, ID_Pelicula, ID_Sala) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTime(1, funcion.getHoraInicio());
            stmt.setTime(2, funcion.getHoraFin());
            stmt.setDate(3, java.sql.Date.valueOf(funcion.getFecha()));
            stmt.setInt(4, funcion.getIdPelicula());
            stmt.setInt(5, funcion.getIdSala());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarFuncion(int idFuncion) throws PersistenciaException {
        String query = "DELETE FROM Funcion WHERE ID_Funcion = ?";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFuncion);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Funcion obtenerFuncionPorId(int idFuncion) throws PersistenciaException {
        String query = "SELECT ID_Funcion, HoraInicio, HoraFin, Fecha, ID_Pelicula, ID_Sala "
                + "FROM Funcion WHERE ID_Funcion = ?";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFuncion);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Funcion funcion = new Funcion();
                    funcion.setIdFuncion(resultSet.getInt("ID_Funcion"));
                    funcion.setHoraInicio(resultSet.getTime("HoraInicio"));
                    funcion.setHoraFin(resultSet.getTime("HoraFin"));
                    funcion.setFecha(resultSet.getDate("Fecha").toLocalDate());
                    funcion.setIdPelicula(resultSet.getInt("ID_Pelicula"));
                    funcion.setIdSala(resultSet.getInt("ID_Sala"));
                    return funcion;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void actualizarFuncion(Funcion funcion) throws PersistenciaException {
        String query = "UPDATE Funcion SET HoraInicio = ?, HoraFin = ?, Fecha = ?, "
                + "ID_Pelicula = ?, ID_Sala = ? WHERE ID_Funcion = ?";
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTime(1, funcion.getHoraInicio());
            stmt.setTime(2, funcion.getHoraFin());
            stmt.setDate(3, java.sql.Date.valueOf(funcion.getFecha()));
            stmt.setInt(4, funcion.getIdPelicula());
            stmt.setInt(5, funcion.getIdSala());
            stmt.setInt(6, funcion.getIdFuncion());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
