/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend.database.usersdb;

import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.model.Conexion;
import java.sql.Connection;
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

    private String INSERT = """
                            INSERT INTO admin.usuarios(nombre, username,password,rol)
                            VALUES (?, ?,?,?);
                            """;

    private String SELECT_BY_USERNAME = """
                                        SELECT * FROM admin.usuarios WHERE username = ? AND password = ?;
                                        """;
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;

    public boolean insert(Usuario user) throws SQLException {
        conn = Conexion.getConnection();
        statement = conn.prepareStatement(INSERT);

        statement.setString(1, user.getNombre());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getRol());

        statement.executeUpdate();
        statement.close();
        return false;
    }

    public Usuario getUserByUsernamePassword(String username, String password) {
        System.out.println("hola "+username);
        System.out.println("pas "+password);
        Usuario user = null;
        try {
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SELECT_BY_USERNAME);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
            while (result.next()) {
                user = new Usuario(
                        result.getString("nombre"), 
                        result.getString("username"), 
                        result.getString("password"), 
                        result.getString("rol"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
