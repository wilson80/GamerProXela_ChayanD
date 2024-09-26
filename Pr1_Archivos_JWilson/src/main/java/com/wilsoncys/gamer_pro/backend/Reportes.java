/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.model.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Jonwil
 */
public class Reportes {
        LinkedList<LinkedList<String>> listaTop10 = new LinkedList<>();

    
        private String INSERT_NEW_EMP = """
            INSERT INTO distribuidora.usuarios (cui, nombre, direccion, telefono, nit, rol, sucursal_id, username, password) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                            """;
        
        
        
        public static void main(String[] args) {
            Reportes r = new Reportes();
            r.top10articuloMasV();
        }
                
        
        public void top10Clientes(){
            // Crear la consulta SQL
String sql = "SELECT c.nombre, c.nit, SUM(v.total) AS total_gastado " +
             "FROM distribuidora.clientes c " +
             "JOIN distribuidora.ventas v ON c.id = v.cliente_id " +
             "GROUP BY c.id, c.nombre, c.nit " +
             "ORDER BY total_gastado DESC " +
             "LIMIT 10;";

// Ejecutar la consulta
            try {
                Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                // Procesar los resultados
                while (rs.next()) {
                LinkedList<String> list = new LinkedList<>();
                    
                    String nombre = rs.getString("nombre");
                    String nit = rs.getString("nit");
                    double totalGastado = rs.getDouble("total_gastado");
                    list.add(nombre);
                    list.add(String.valueOf(totalGastado));
                    listaTop10.add(list);
                    System.out.println("Cliente: " + nombre + ", NIT: " + nit + ", Total gastado: Q" + totalGastado);
                }
            } catch (Exception e) {
                System.out.println("Try en consulta ");
            }
            
        }
        
        
    public void top10articuloMasV(){
  
        // Establecer conexión a la base de datos
        try {
                Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement(); 

            // Consulta a la vista
            String query = "SELECT * FROM distribuidora.top_10_articulos_mas_vendidos";

            try (ResultSet resultSet = statement.executeQuery(query)) {
                System.out.println("Top 10 Artículos Más Vendidos:");
                System.out.printf("%-20s %-30s %-15s%n", "Producto ID", "Producto Nombre", "Total Vendido");
                System.out.println("----------------------------------------------------");

                // Procesar los resultados
                while (resultSet.next()) {
                    LinkedList<String> list = new LinkedList<>();
                    String productoId = resultSet.getString("producto_id");
                    String productoNombre = resultSet.getString("producto_nombre");
                    int totalVendido = resultSet.getInt("total_vendido");
                    list.add(productoNombre);
                    list.add(String.valueOf(totalVendido));
                    listaTop10.add(list);
                    System.out.printf("%-20s %-30s %-15d%n", productoId, productoNombre, totalVendido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores en la conexión
        }
    
}

    
        public void top2S(){
           try 
           {
               Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement(); 

            // Consulta para obtener el top 2 de sucursales que más ingresos han generado
            String query = "SELECT s.id AS sucursal_id, s.nombre AS sucursal_nombre, SUM(v.total) AS total_ingresos "
                         + "FROM distribuidora.sucursales s "
                         + "JOIN distribuidora.ventas v ON s.id = v.sucursal_id "
                         + "GROUP BY s.id, s.nombre "
                         + "ORDER BY total_ingresos DESC "
                         + "LIMIT 2;";

            try (ResultSet resultSet = statement.executeQuery(query)) {
                System.out.println("Top 2 Sucursales que Más Ingresos Han Generado:");
                System.out.printf("%-20s %-30s %-15s%n", "Sucursal ID", "Sucursal Nombre", "Total Ingresos");
                System.out.println("-----------------------------------------------------");

                // Procesar los resultados
                while (resultSet.next()) {
                    LinkedList<String> list = new LinkedList<>();

                    String sucursalId = resultSet.getString("sucursal_id");
                    String sucursalNombre = resultSet.getString("sucursal_nombre");
                    double totalIngresos = resultSet.getDouble("total_ingresos");
                    System.out.printf("%-20s %-30s %-15.2f%n", sucursalId, sucursalNombre, totalIngresos);
                    list.add(sucursalNombre);
                    list.add(String.valueOf(totalIngresos));
                    listaTop10.add(list);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores en la conexión
        }
            
            
            
        }

    

        

        
        
        
    public LinkedList<LinkedList<String>> getList() {
        return listaTop10;
    }
        
        
        
    
}
