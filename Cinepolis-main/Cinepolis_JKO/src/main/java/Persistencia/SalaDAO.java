/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import entidad.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private ConexionBD conexionBD;

    public SalaDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public void agregarSala(Sala sala) throws SQLException {
        String query = "INSERT INTO Sala (Nombre, AsientosDisponibles, PrecioBoleto, ID_Sucursal) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sala.getNombre());
            stmt.setInt(2, sala.getAsientosDisponibles());
            stmt.setInt(3, sala.getPrecioBoleto());
            stmt.setInt(4, sala.getIdSucursal());
            stmt.executeUpdate();
        }
    }

    public List<Sala> obtenerSalas() throws SQLException {
        List<Sala> salas = new ArrayList<>();
        String query = "SELECT * FROM Sala";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("ID_Sala"));
                sala.setNombre(rs.getString("Nombre"));
                sala.setAsientosDisponibles(rs.getInt("AsientosDisponibles"));
                sala.setPrecioBoleto(rs.getInt("PrecioBoleto"));
                sala.setIdSucursal(rs.getInt("ID_Sucursal"));
                salas.add(sala);
            }
        }
        return salas;
    }

}
