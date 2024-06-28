/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import entidad.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensajeDAO {
    private ConexionBD conexionBD;

    public MensajeDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public void agregarMensaje(Mensaje mensaje) throws SQLException {
        String query = "INSERT INTO Mensaje (Mensaje, ID_Sucursal) VALUES (?, ?)";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, mensaje.getMensaje());
            stmt.setInt(2, mensaje.getIdSucursal());
            stmt.executeUpdate();
        }
    }

    public List<Mensaje> obtenerMensajes() throws SQLException {
        List<Mensaje> mensajes = new ArrayList<>();
        String query = "SELECT * FROM Mensaje";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setIdMensaje(rs.getInt("ID_Mensaje"));
                mensaje.setMensaje(rs.getString("Mensaje"));
                mensaje.setIdSucursal(rs.getInt("ID_Sucursal"));
                mensajes.add(mensaje);
            }
        }
        return mensajes;
    }

}
