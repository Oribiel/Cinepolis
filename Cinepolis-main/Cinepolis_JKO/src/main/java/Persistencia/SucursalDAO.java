/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Persistencia.excepcion.PersistenciaException;
import Persistencia.interfaces.IConexionBD;
import Persistencia.interfaces.ISucursalDAO;
import entidad.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO implements ISucursalDAO{
    private IConexionBD conexionBD;

    public SucursalDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     *
     * @param sucursal
     * @throws PersistenciaException
     */
    @Override
    public void agregarSucursal(Sucursal sucursal) throws PersistenciaException {
        try{
        String query = "INSERT INTO Sucursal (Nombre, Latitud, Longitud, SRID, Ciudad, Colonia, Calle, Numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sucursal.getNombre());
            stmt.setDouble(2, sucursal.getLatitud());
            stmt.setDouble(3, sucursal.getLongitud());
            stmt.setInt(4, sucursal.getSrid());
            stmt.setString(5, sucursal.getCiudad());
            stmt.setString(6, sucursal.getColonia());
            stmt.setString(7, sucursal.getCalle());
            stmt.setString(8, sucursal.getNumero());
            stmt.executeUpdate();
        }
        }
        catch(SQLException e){
            throw new PersistenciaException("error al agregar sucursal");
        }
    }

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<Sucursal> obtenerSucursales() throws PersistenciaException {
    List<Sucursal> sucursales = new ArrayList<>();
    String query = "SELECT * FROM Sucursal";

    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setIdSucursal(rs.getInt("ID_Sucursal"));
            sucursal.setNombre(rs.getString("Nombre"));
            sucursal.setLatitud(rs.getDouble("Latitud"));
            sucursal.setLongitud(rs.getDouble("Longitud"));
            sucursal.setSrid(rs.getInt("SRID"));
            sucursal.setCiudad(rs.getString("Ciudad"));
            sucursal.setColonia(rs.getString("Colonia"));
            sucursal.setCalle(rs.getString("Calle"));
            sucursal.setNumero(rs.getString("Numero"));
            sucursales.add(sucursal);
        }

    } catch (SQLException e) {
        // Incluye el mensaje original de la excepción para facilitar la depuración
        throw new PersistenciaException("Error al obtener las sucursales" );
    }

    return sucursales;
}
    
    

}
