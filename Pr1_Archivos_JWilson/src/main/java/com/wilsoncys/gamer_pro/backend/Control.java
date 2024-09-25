/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.backend.database.usersdb.UsersDb;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.fronted.panelAdmin;
import com.wilsoncys.gamer_pro.fronted.panelCajero;
import com.wilsoncys.gamer_pro.fronted.panel_Bodeguero;
import com.wilsoncys.gamer_pro.fronted.panel_Inventario;
import com.wilsoncys.gamer_pro.fronted.principalWindow;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Control {
    public principalWindow principalWin;
    private UsersDb usersDb;
    private Usuario searchUser = null;
    private String rolUser = "";
    private int idSucursalAcutal = 0;

    
    public Control() {
        this.usersDb = new UsersDb();
        iniciar();
    }
 
    
    public void iniciar(){
        principalWin = new principalWindow(this);
        principalWin.setExtendedState(principalWin.MAXIMIZED_BOTH);
        principalWin.setVisible(true);
        
    }

    public boolean identificarUser(String user, String pass) {
        boolean succes = false;
        String name = user;
        String password = pass;
        UsersDb usersDb = new UsersDb();
        searchUser = usersDb.getUserByUsernamePassword(name, password);
        if (searchUser != null) {
              rolUser = searchUser.getRol();
              idSucursalAcutal = searchUser.getSucursalId();
              succes = true;
        }else{
            
        }      
        return succes; 
    }
    
    
    
    public void inciarUser(){
        switch (rolUser) {
            case "ADMIN":
                iniciarAdmin();
                break;
            case "Bodeguero":
                iniciarBodeguero();
                break;
            case "Cajero":
                iniciarCajero();
                break;
            case "Inventarista":
                iniciarInventarista();
                break;
            default:
                System.out.println("default al inciar sesion");
                break;
                
        }
        
    }
       
        
    public void iniciarAdmin(){
        panelAdmin panel = new panelAdmin(this);
        panel.setBounds(10, 0, 1074, 852);
        principalWin.addThePanelGeneral(panel);
        
    }
    
    public void iniciarCajero(){
        panelCajero panel = new panelCajero(this);
        panel.setBounds(10, 0, 1074, 1000);
        principalWin.addThePanelGeneral(panel);
        
    }

    
    private void iniciarInventarista() {
        panel_Inventario panel = new panel_Inventario(this);
        panel.setBounds(10, 5, 950,  600);
        principalWin.addThePanelGeneral(panel);
    }

    private void iniciarBodeguero() {
        panel_Bodeguero panel = new panel_Bodeguero(this);
        panel.setBounds(10, 5, 950,  600);
        principalWin.addThePanelGeneral(panel);
    }
    
    
    public void crearEmpleado(Usuario usuario) throws SQLException {
        UsersDb crear = new UsersDb();
        crear.insert(usuario);
    }
    
//    public void updateInventario(Usuario usuario) throws SQLException {
//        UsersDb crear = new UsersDb();
//        crear.insert(usuario);
//    }
    
    
    
    public int getIdSucursalActual() {
        return idSucursalAcutal;
    }
    
    
    
    
}
