/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import com.wilsoncys.gamer_pro.backend.Productos_porVenta;
import com.wilsoncys.gamer_pro.backend.database.usersdb.Producto_querys;
import com.wilsoncys.gamer_pro.backend.models.Producto;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Jonwil
 */
public class panel_Productos extends javax.swing.JPanel {
    private Productos_porVenta oneSale = new Productos_porVenta();
    private Control control;
    private int alturaItem = 60;
    private int altura = 0;
    private int contadorPaneles = 0;
    private  Producto currentProd;
    private int cantidadProductos = 0;
    private double generalSuma = 0;

    
    private LinkedList<panelItem_cajero> items;
    private LinkedList<panelItem_cajero> itemsFinal;

    
    
     // Crear el panel principal con null layout
    JPanel panelContenedor = new JPanel();
    JScrollPane scrollPane;
  
    public panel_Productos(Control control) {
        initComponents();
        this.control = control;
        items = new LinkedList<>();
        itemsFinal = new LinkedList<>();
         oneSale = new Productos_porVenta();

        
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(470, 50));  // Tamaño inicial
        
         // Crear un JScrollPane que contiene el panel con otros paneles dentro
        scrollPane = new JScrollPane(panelContenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 850, 470);
        
        contenedorScroll.add(scrollPane);
        contenedorScroll.updateUI();
    }

    
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldBuscar = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        search = new javax.swing.JButton();
        contenedorScroll = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        labelAllProd = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

        fieldBuscar.setText("halo1");

        botonIngresar.setText("Ingresar Productos");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        contenedorScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorScroll.setLayout(null);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        labelAllProd.setText("Cantidad de productos: ");

        labelTotal.setText("Total (Q) : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(search))
                    .addComponent(contenedorScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(labelAllProd, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(contenedorScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelAllProd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed




        if(contadorPaneles ==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto");
            return;
        }
        boolean error = false;
       for (int i = 0; i < items.size(); i++) {
            if(items.get(i).isEliminado()){
                items.remove(i);
            }else{
                itemsFinal.add(items.get(i));
            }
        }
 
        
        try {
//                Producto_querys update = new Producto_querys();
//                update.ingresarProductos(5, "halo1");
            for (panelItem_cajero item : itemsFinal) {
                Producto_querys update = new Producto_querys();
                update.updateBodega(item.getCantidad(), item.getNombre());
                
            }
        } catch (SQLException  e) {
            error =true;
            JOptionPane.showMessageDialog(null, "Error al igresar un producto a bodega");
        }
         if(!error){
            JOptionPane.showMessageDialog(null, "Se han Ingresado: " 
                    + items.size() + " clases de productos Exitosamente");
            panelContenedor.removeAll();
            panelContenedor.setPreferredSize(new Dimension(470, 50));  // Tamaño inicial
            contadorPaneles =0;
            items = new LinkedList<>();
            itemsFinal = new LinkedList<>();
            this.updateUI();
            
         }
        itemsFinal = new LinkedList<>();
         
         
        
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
 //realizar busqueda y verificar existencias / set al producto Actual 
    currentProd = oneSale.searchProd_validarExist(fieldBuscar.getText(), 1);

    if(currentProd != null){
          panelItem_cajero newPanel_prod = new panelItem_cajero(this);
          newPanel_prod.setProd(currentProd);       //como un constructor


        newPanel_prod.setBounds(10, 10 + (contadorPaneles * 80), 820, 80);  
                                        // Colocar panel en la siguiente posición
        panelContenedor.add(newPanel_prod);
        contadorPaneles++;
        panelContenedor.setPreferredSize(new Dimension(820, 10+(contadorPaneles * 80)));
        panelContenedor.updateUI();
        oneSale.addList(newPanel_prod);
        items.add(newPanel_prod);
        cantidadProductos += newPanel_prod.getCantidad();
        labelAllProd.setText("Cantidad productos" + cantidadProductos);
        generalSuma += newPanel_prod.getSubtotal();
        labelTotal.setText( "Total: " + generalSuma);
        

    } 
 
        
    }//GEN-LAST:event_searchActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        items = new LinkedList<>();
        panelContenedor.removeAll();
        panelContenedor.setPreferredSize(new Dimension(470, 50));  // Tamaño inicial
        contadorPaneles =0;
        this.updateUI();
    }//GEN-LAST:event_botonCancelarActionPerformed
    public void removerPanel(Component comp){
        panelContenedor.remove(comp);
        panelContenedor.updateUI();
    }
    
public void otroProd(){
    cantidadProductos++;
    
    labelAllProd.setText("Cantidad productos: " +  cantidadProductos);
    labelAllProd.setText("Cantidad productos: " +  cantidadProductos);
}
public void acumular(double algo){
    labelTotal.setText("Total: " + generalSuma);
    generalSuma+= algo;
}
public void desAcumular(double algo){
    generalSuma = generalSuma - algo;
    labelTotal.setText("Total: " + generalSuma);
}

public void quitarProd(){
    cantidadProductos--;
    labelAllProd.setText("Cantidad productos: " +  cantidadProductos);
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JPanel contenedorScroll;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JLabel labelAllProd;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
