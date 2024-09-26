/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.backend.database.usersdb.UsersDb;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.fronted.FormNuevaVenta;
import com.wilsoncys.gamer_pro.fronted.PanelAdmin;
import com.wilsoncys.gamer_pro.fronted.panelCajero;
import com.wilsoncys.gamer_pro.fronted.panel_Bodeguero;
import com.wilsoncys.gamer_pro.fronted.panel_Inventario;
import com.wilsoncys.gamer_pro.fronted.principalWindow;
import com.wilsoncys.gamer_pro.fronted.ventanitas.simpleReport;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Control {
    public principalWindow principalWin;
    
    
    private  Usuario currentUser;
    private Usuario searchUser = null;
    private String rolUser = "";
    private int idSucursalAcutal = 0;
    
    private panelCajero ventanaCajero;
    private ControlCajero controlCajero;
    private FormNuevaVenta formFactura;
    
    private PanelAdmin panelAdmin;
    
    
    

    
    public Control() {
        this.currentUser = null;
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
            currentUser = searchUser;
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
        PanelAdmin panel = new PanelAdmin(this);
        panel.setBounds(10, 0, 1400, 852);
        principalWin.addThePanelGeneral(panel, currentUser);
        
    }
    
    public void iniciarCajero(){
        panelCajero panel = new panelCajero(this);
        panel.setBounds(10, 0, 1374, 634);
        principalWin.addThePanelGeneral(panel, currentUser);
        
    }
    
    
    private void iniciarInventarista() {
        panel_Inventario panel = new panel_Inventario(this);
        panel.setBounds(10, 5, 950,  600);
        principalWin.addThePanelGeneral(panel, currentUser);
    }

    private void iniciarBodeguero() {
        panel_Bodeguero panel = new panel_Bodeguero(this);
        panel.setBounds(10, 5, 950,  600);
        principalWin.addThePanelGeneral(panel, currentUser);
    }
    
    
    public void crearEmpleado(Usuario usuario) throws SQLException {
        UsersDb crear = new UsersDb();
        crear.insert(usuario);
    }
    
//    public void updateInventario(Usuario usuario) throws SQLException {
//        UsersDb crear = new UsersDb();
//        crear.insert(usuario);
//    }
    public void controlVenta(FormNuevaVenta form)  {
        controlCajero.CrearVenta(form);
    }
    
    
    
    
    public void identificarConsulta(int eleccion){
        switch (eleccion) {
            case 1:
                historialDescuentos();
                break;
            case 2:
                top10Ventas();
                break;
            case 3:
                top2Sucursales();
                break;
            case 4:
                top10Articulos();
                break;
            case 5:
                top10clientes();
                break;
            default:
                break;
                
        }
    }
    public void historialDescuentos(){
        top10Articulos();
    }
    public void top10Ventas(){
        top10Articulos();
        
    }
    public void top2Sucursales(){
       Reportes rep = new Reportes();
        rep.top2S();
        LinkedList<LinkedList<String>> lista = rep.getList();
        LinkedList<simpleReport> paneles = new LinkedList<>();

        for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i)!=null){
                        simpleReport sim = new simpleReport();
                        sim.setNombre(lista.get(i).get(0));
                        sim.setCantidad(lista.get(i).get(1));
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                    }else{
                        simpleReport sim = new simpleReport();
                        sim.setNombre("-");
                        sim.setCantidad(" ");
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                    }
        }
    }
    
    
                //que mas vendidos
    public void top10Articulos(){
           Reportes rep = new Reportes();
        rep.top10articuloMasV();
        LinkedList<LinkedList<String>> lista = rep.getList();
        LinkedList<simpleReport> paneles = new LinkedList<>();

        for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i)!=null){
                        simpleReport sim = new simpleReport();
                        sim.setNombre(lista.get(i).get(0));
                        sim.setCantidad(lista.get(i).get(1));
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                        
                    }else{
                        simpleReport sim = new simpleReport();
                        sim.setNombre("-");
                        sim.setCantidad(" ");
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                        
                    }
            
        }
        
    }
    
    public void top10clientes(){    //que mas dinero han gastado
        Reportes rep = new Reportes();
        rep.top10Clientes();
        LinkedList<LinkedList<String>> lista = rep.getList();
        LinkedList<simpleReport> paneles = new LinkedList<>();
        


        for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i)!=null){
                        simpleReport sim = new simpleReport();
                        sim.setNombre(lista.get(i).get(0));
                        sim.setCantidad(lista.get(i).get(1));
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                        
                    }else{
                        simpleReport sim = new simpleReport();
                        sim.setNombre("-");
                        sim.setCantidad(" ");
                        panelAdmin.getContenedorReport().add(sim);
                        panelAdmin.updateUI();
                        
                    }
            
        }
        
        
    }
        
    
    
    
    
    
    
    public int getIdSucursalActual() {
        return idSucursalAcutal;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public void setControlCajero(ControlCajero controlCajero) {
        this.controlCajero = controlCajero;
    }

    public void setFormFactura(FormNuevaVenta formFactura) {
        this.formFactura = formFactura;
    }

    public void setPanelAdmin(PanelAdmin panel) {
        this.panelAdmin = panel;
    }
   
    
    
    
    
    
    
    
}
