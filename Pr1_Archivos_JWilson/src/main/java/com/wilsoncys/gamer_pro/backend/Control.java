/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.backend.database.usersdb.UsersDb;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.fronted.MenuAdmin;
import com.wilsoncys.gamer_pro.fronted.principalWindow;

/**
 *
 * @author Jonwil
 */
public class Control {
    public principalWindow vPrincipal;
    private UsersDb usersDb;

    
    public Control() {
        this.usersDb = new UsersDb();
        iniciar();
    }
 
    
    public void iniciar(){
        vPrincipal = new principalWindow(this);
        vPrincipal.setExtendedState(vPrincipal.MAXIMIZED_BOTH);
        vPrincipal.setVisible(true);
        
    }

    public boolean identificarUser(String user, String pass) {
        boolean succes = false;
        String name = user;
        String password = pass;
        System.out.println(name);
        System.out.println(password);
        UsersDb usersDb = new UsersDb();
        Usuario search = usersDb.getUserByUsernamePassword(name, password);
        if (search != null) {
            //entrar el menu correspondiente
            String rol = search.getRol();
            switch (rol) {
                case "ADMIN":
                    succes = true;
                    new MenuAdmin(new Control(), search).setVisible(true);
                    
                    break;
                    case "BODEGA":
                    
                    break;
                    case "INVENTARIO":
                    break;
                default:
                        System.out.println("default switch");
                    break;
            }
        } else {
                System.out.println("no se encontro");
        }
        return succes; 
    }
    
    
    
    
    
    
}
