/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend.database.usersdb;

import com.wilsoncys.gamer_pro.backend.models.Producto;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.model.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonwil
 */
public class Producto_querys {

    private String SELECT_P = """
           SELECT * FROM distribuidora.productos
            WHERE id = ? OR nombre = ?;
                            """;

    private String UPDATE = """
                            UPDATE distribuidora.productos
                            SET cantidadEnBodega = cantidadEnBodega + ?
                            WHERE id = ? OR nombre = ?;
                                        """;
    private String UPDATE_INVENTARIO = """
                            UPDATE distribuidora.productos
                            SET cantidadEnBodega = cantidadEnBodega + ?
                            WHERE id = ? OR nombre = ?;
                                        """;
 
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;

    public boolean ingresarInventario(int cantidadS, String idProducto) throws SQLException {
        conn = null;
        conn = Conexion.getConnection();
         // Sentencia SQL para llamar a la función 'mover_producto'
        String callSQL = "{ ? = call distribuidora.mover_producto(?, ?) }";  // Formato para invocar una función en PostgreSQL

        try{
            CallableStatement callableStatement = conn.prepareCall(callSQL);
                    
            // Registrar el parámetro de salida que recibe el valor booleano (el valor de retorno de la función)
            callableStatement.registerOutParameter(1, java.sql.Types.BOOLEAN);

            // Establecer los parámetros de entrada (id_producto y cantidad)
            callableStatement.setString(2, idProducto);
            callableStatement.setInt(3, cantidadS);

            // Ejecutar la llamada a la función
            callableStatement.execute();

            // Recuperar y retornar el valor de retorno de la función
//            callableStatement.close();
            return callableStatement.getBoolean(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // En caso de error, retornar false
        }
        
    }
    
    public boolean updateBodega(int cantidadS, String name) throws SQLException {
 
        conn = Conexion.getConnection();
        statement = conn.prepareStatement(UPDATE);
        statement.setInt(1, cantidadS);
        statement.setString(2, name);
        statement.setString(3, name);

        statement.executeUpdate();
        statement.close();
        return false;
    }

    
    
    public Producto getUserById_nombre(String id_codigo) {
        Producto prod = null;
        try {
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SELECT_P);
            statement.setString(1, id_codigo);
            statement.setString(2, id_codigo);
            result = statement.executeQuery();
            while (result.next()) {
// String nombre, double precio, String pasillo, int sucursal, int cantidadBodega, int cantidadExibicion) {
                prod = new Producto(
                        result.getString("id"), 
                        result.getString("descripcion"), 
                        result.getString("nombre"), 
                        result.getDouble("precio"), 
                        result.getString("pasillo"), 
                        result.getInt("sucursal_id"), 
                        result.getInt("cantidadenBodega"), 
                        result.getInt("cantidad_en_exibicion")); 
            }
//            if(prod!=null){
//                System.out.println(prod.toString());
//            }
           return prod;
        } catch (SQLException ex) {
               ex.printStackTrace();
            return null;
        }
        
        
    }
    
}
