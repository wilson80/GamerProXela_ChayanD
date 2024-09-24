/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonwil
 */
 
public class Conexion {

    
//    private String URL = "jdbc:postgresql://localhost:5432/TIENDA"; // Cambia el puerto si es necesario
    private String URL = "jdbc:postgresql://localhost:5432/GamerPrueba";

    private String USER = "postgres";
    private String PASSWORD = "00android";

    private static Conexion conexionSingleton = null;

    private static Connection CONECCION = null;

    public Conexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Cambia a PostgreSQL Driver

            CONECCION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver: " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (conexionSingleton == null) {
            conexionSingleton = new Conexion();
        }
        return CONECCION;
    }
    
    
    
        
    public static void main(String[] args) {
        try {
            getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}
