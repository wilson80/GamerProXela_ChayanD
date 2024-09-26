/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
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
public class panel_Inventario extends javax.swing.JPanel {
    private Control control;
    private int alturaItem = 60;
    private int altura = 0;
    private int contadorPaneles = 0;
    
    private LinkedList<panelItem_inventario> items;
    private LinkedList<panelItem_inventario> itemsFinal;
    
     // Crear el panel principal con null layout
    JPanel panelContenedor = new JPanel();
    JScrollPane scrollPane;
  
    public panel_Inventario(Control control) {
        initComponents();
        this.control = control;
        items = new LinkedList<>();
        itemsFinal = new LinkedList<>();
        
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        contenedorScroll = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        fieldBuscar.setText("codigoProducto");

        jButton1.setText("Marcar como En exibicion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        contenedorScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorScroll.setLayout(null);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton3))
                            .addComponent(contenedorScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(contenedorScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(contadorPaneles ==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto");
            return;
        }
        boolean succes = true;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).isEliminado()){
                items.remove(i);
            }else{
                itemsFinal.add(items.get(i));
            }
        }
 
        System.out.println("Sizeee" + itemsFinal.size());
        for (panelItem_inventario item_inventario : itemsFinal) {
            System.out.println(item_inventario.getCantidad());
        }

        try {
            for (panelItem_inventario item : itemsFinal) {
                Producto_querys update = new Producto_querys();
                  succes = update.ingresarInventario(item.getCantidad(), item.getId());
                if(succes){
//                    JOptionPane.showMessageDialog(null, "Producto trasladado Exitosamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al trasladar producto de bodega a inventario");
                }
            }
            
            
        } catch (SQLException  e) {
            succes =false;
            JOptionPane.showMessageDialog(null, "Error al igresar un producto a bodega");
            items = new LinkedList<>();
            itemsFinal = new LinkedList<>();
        }
         if(succes){
            JOptionPane.showMessageDialog(null, "Se han Ingresado: " 
                    + itemsFinal.size() + " clases de productos Exitosamente");
            panelContenedor.removeAll();
            panelContenedor.setPreferredSize(new Dimension(470, 50));  // Tamaño inicial
            contadorPaneles =0;
            items = new LinkedList<>();
            itemsFinal = new LinkedList<>();
            this.updateUI();
         }
            itemsFinal = new LinkedList<>();
         
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             // Ajustar el tamaño del contenedor según el número de paneles
        //realizar busqueda

        Producto productEncontrado = null;
        try {
            Producto_querys pro = new Producto_querys();
              productEncontrado =  pro.getProcductoBynombre_id(fieldBuscar.getText());
           
        } catch ( Exception e) {
            e.printStackTrace();
        }
        
        if(productEncontrado!=null){
              panelItem_inventario nuevoPanel = new panelItem_inventario(this);
              nuevoPanel.setNombre(productEncontrado.getNombre());
              nuevoPanel.setDescripcion(productEncontrado.getDescripcion());
              nuevoPanel.setPrecio(productEncontrado.getPrecio());
              nuevoPanel.setId(productEncontrado.getId());
              nuevoPanel.setPasillo(productEncontrado.getPasillo());
              nuevoPanel.setEnBodega(productEncontrado.getCantidadBodega());
              nuevoPanel.setEnExibicion(productEncontrado.getCantidadExibicion());
                            
              
        nuevoPanel.setBounds(10, 10 + (contadorPaneles * 80), 820, 80);  // Colocar panel en la siguiente posición
//            nuevoPanel.setId(contadorPaneles);
            panelContenedor.add(nuevoPanel);
            contadorPaneles++;
            panelContenedor.setPreferredSize(new Dimension(820, 10 + (contadorPaneles * 80)));
            panelContenedor.updateUI();
            items.add(nuevoPanel);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto solicitado");
        }
        
 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        items = new LinkedList<>();
        panelContenedor.removeAll();
        panelContenedor.setPreferredSize(new Dimension(470, 50));  // Tamaño inicial
        contadorPaneles =0;
        this.updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void removerPanel(Component comp){
        panelContenedor.remove(comp);
        panelContenedor.updateUI();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorScroll;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
