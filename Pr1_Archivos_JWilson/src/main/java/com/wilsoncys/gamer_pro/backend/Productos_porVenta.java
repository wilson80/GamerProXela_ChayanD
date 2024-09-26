/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.backend.database.usersdb.Producto_querys;
import com.wilsoncys.gamer_pro.backend.models.Producto;
import com.wilsoncys.gamer_pro.fronted.panelItem_cajero;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class Productos_porVenta {
    LinkedList<panelItem_cajero> products; 
    boolean existenciasDisp = false;

    public Productos_porVenta() {
          products = new LinkedList<>();
    }
     
    
    
    public Producto searchProd_validarExist  (String id_nombre, int cantidadSolicitada){
        Producto_querys pro = new Producto_querys();
        Producto productSearched = pro.getProcductoBynombre_id(id_nombre);
        if(pro!=null){
            if(!limitarCompra(productSearched, cantidadSolicitada) ){
                return productSearched;
            }else{
            JOptionPane.showMessageDialog(null, "El producto solicitado"
                    + " no cuenta con existencias");
                return null;
            }
        }else{
            existenciasDisp = false;
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto solicitado");
            return null;
        }        
    }
    
    public boolean limitarCompra(Producto prod, int countSolicitada){
        if(prod.getCantidadBodega() < countSolicitada){
            existenciasDisp = true;
            return true;
        }else{
            existenciasDisp = false;
            return false;
        }
    }

    
    public void addList(panelItem_cajero prod){
        products.add(prod);
        
    }
    
    
    public boolean isExistDisp() {
        return existenciasDisp;
    }
    
    
    public void verificarProdAgregado(){
        
    }
    
    
    
    
    
    
    
    
    
}
