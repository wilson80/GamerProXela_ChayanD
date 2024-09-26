/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend;

import com.wilsoncys.gamer_pro.backend.database.usersdb.Producto_querys;
import com.wilsoncys.gamer_pro.backend.models.Producto;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import com.wilsoncys.gamer_pro.fronted.FormNuevaVenta;
import com.wilsoncys.gamer_pro.fronted.panelItem_cajero;
import com.wilsoncys.gamer_pro.fronted.panel_Productos;
import com.wilsoncys.gamer_pro.model.Conexion;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class ControlCajero {
    LinkedList<panelItem_cajero> products; 
    boolean existenciasDisp = false;
    private Usuario usuario;
    private panel_Productos panelTuplas;
    private double total = 0;

    public ControlCajero() {
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
        if(prod.getCantidadExibicion()< countSolicitada){
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
    
    
    
    public void calcularTotal(){
        for (panelItem_cajero product : products) {
            total += product.getPrecio()*product.getCantidad();
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void CrearVenta(FormNuevaVenta form){
        calcularTotal();
        System.out.println(">>>>> " + products.size());
        for (panelItem_cajero product : products) {
// Parámetros de la función
 
        // Intentar conexión y ejecución de la consulta
        try {
            Connection conn = Conexion.getConnection();
            // Llamada a la función con parámetros
            String callFunction = "{? = call distribuidora.registrar_venta(?, ?, ?, ?, ?, ?)}";
            
            // Crear CallableStatement
            CallableStatement stmt = conn.prepareCall(callFunction);
            
            // Registrar el primer parámetro como resultado de tipo String
            stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            
            // Configurar los parámetros de entrada
            stmt.setString(2, form.getFieldNit().getText());
            stmt.setString(3, form.getFieldNombre().getText());
            stmt.setString(4, usuario.getCui());
            stmt.setInt(5, usuario.getSucursalId());
//            stmt.setBigDecimal(6, new BigDecimal(String.valueOf(total)));
            stmt.setString(6, product.getCodigoP());
            stmt.setInt(7, product.getCantidad());
            
            // Ejecutar la función
            stmt.execute();
            
            // Obtener el resultado
            String resultMessage = stmt.getString(1);
            JOptionPane.showMessageDialog(null, resultMessage);
            System.out.println("Resultado de la venta: " + resultMessage);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

            
        }
        
        
    }
    
    
//    SELECT distribuidora.registrar_venta(
//    '1234567',           -- NIT del cliente (nuevo)
//    'Juan Pérez',        -- Nombre del cliente (nuevo)
                    //    '1234567890101',     -- CUI del usuario (empleado)
                        //    1,                   -- ID de la sucursal (Parque)
//    31.00,               -- Total de la venta
//    'halo1',             -- ID del producto
//    2                    -- Cantidad del producto
//);

    public void setPanel(panel_Productos panel) {
        this.panelTuplas = panel;
    }

    public void setProducts(LinkedList<panelItem_cajero> products) {
        this.products = products;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
  
    
    
    
    
}
