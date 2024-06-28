/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import entidad.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    private ConexionBD conexionBD;

    public GeneroDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public void agregarGenero(Genero genero) throws SQLException {
        String query = "INSERT INTO Genero (Nombre) VALUES (?)";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, genero.getNombre());
            stmt.executeUpdate();
        }
    }

    public List<Genero> obtenerGeneros() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        String query = "SELECT * FROM Genero";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("ID_Genero"));
                genero.setNombre(rs.getString("Nombre"));
                generos.add(genero);
            }
        }
        return generos;
    }

}
