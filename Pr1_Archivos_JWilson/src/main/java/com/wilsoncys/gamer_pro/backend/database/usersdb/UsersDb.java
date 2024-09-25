/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend.database.usersdb;

import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.model.Conexion;
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
public class UsersDb {

    private String INSERT_NEW_EMP = """
            INSERT INTO distribuidora.usuarios (cui, nombre, direccion, telefono, nit, rol, sucursal_id, username, password) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                            """;

    private String SELECT_BY_USERNAME_EMP = """
      SELECT * FROM distribuidora.usuarios WHERE username = ? AND password = ?;
                                        """;
    private String SELECT_BY_USERNAME_ADMIN = """
                                        SELECT * FROM administradores.admins WHERE username = ? AND password = ?;
                                        """;
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;

    public boolean insert(Usuario user) throws SQLException {
        conn = Conexion.getConnection();
        statement = conn.prepareStatement(INSERT_NEW_EMP);
// (cui, nombre, direccion, telefono, fecha_ingreso, nit, rol, sucursal_id, username, password) 
        statement.setString(1, user.getCui());
        statement.setString(2, user.getNombre());
        statement.setString(3, user.getDireccion());
        statement.setString(4, user.getTelefono());
//        statement.setDate(5, Date.valueOf(user.getFechaIngreso()));
        statement.setString(5, user.getNit());
        statement.setString(6, user.getRol());
        statement.setInt(7, user.getSucursalId());
        statement.setString(8, user.getUsername());
        statement.setString(9, user.getPassword());

        statement.executeUpdate();
        statement.close();
        return false;
    }

    public Usuario getUserByUsernamePassword(String username, String password) {
        Usuario user = null;
        try {
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SELECT_BY_USERNAME_EMP);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
//  , String cui, String nombre, String direccion, String telefono, String nit, int sucursalId, String username, String password, String rol) {
            while (result.next()) {
                user = new Usuario(
                        result.getString("cui"), 
                        result.getString("nombre"), 
                        result.getString("direccion"), 
                        result.getString("telefono"), 
                        result.getString("nit"), 
                        result.getInt("sucursal_id"), 
                        result.getString("username"), 
                        result.getString("password"), 
                        result.getString("rol"));
            }
            if(user == null){
                try {
                    conn = Conexion.getConnection();
                    statement = conn.prepareStatement(SELECT_BY_USERNAME_ADMIN);
                    statement.setString(1, username);
                    statement.setString(2, password);
                    result = statement.executeQuery();
                    while (result.next()) {
                       user = new Usuario(
                            result.getString("cui"), 
                            result.getString("nombre"), 
                            result.getString("direccion"), 
                            result.getString("telefono"), 
                            result.getString("nit"), 
                            result.getInt("sucursal_id"), 
                            result.getString("username"), 
                            result.getString("password"), 
                            result.getString("rol"));
                    }
                    return user;
                } catch (SQLException e) {
                         System.out.println("Try dentro");
                    e.printStackTrace();
                    return null;
                }
            }else{
                return user;
            }
        } catch (SQLException ex) {
               ex.printStackTrace();
            return null;
        }
        
    }
    
    
     
    
}
