/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nanom
 */
public class ConexionDB {

    private Connection conexion = null;

    public ConexionDB() {
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:C:/Users/nanom/OneDrive/Escritorio/ACCESO A DATOS/SQLite/tienda.db3";
            conexion = DriverManager.getConnection(url);

            System.out.println("Conexion exitosa a la base de datos SQLite.");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
