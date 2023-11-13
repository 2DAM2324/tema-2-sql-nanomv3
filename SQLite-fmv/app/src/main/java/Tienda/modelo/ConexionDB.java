/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nanom
 */
public class ConexionDB {

    private Connection conexion;

    public ConexionDB() {
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:tienda.db3";
            conexion = DriverManager.getConnection(url);

            System.out.println("Conexi�n exitosa a la base de datos SQLite.");

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
                System.out.println("Conexi�n cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
