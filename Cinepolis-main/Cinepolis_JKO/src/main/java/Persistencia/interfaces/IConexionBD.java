/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jesus
 */
public interface IConexionBD {
    
        public Connection crearConexion() throws SQLException;

    
}
