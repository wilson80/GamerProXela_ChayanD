/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class panelCajero extends javax.swing.JPanel {
    private Control control;
    /**
     * Creates new form panelAdmin
     */
    public panelCajero(Control control) {
        initComponents();
        this.control = control;
        agregarPaneles();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        paneNewVenta = new javax.swing.JTabbedPane();
        contenedorAgregar = new javax.swing.JPanel();
        paneModCliente = new javax.swing.JTabbedPane();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        contenedorAgregar.setLayout(null);
        paneNewVenta.addTab(" ", contenedorAgregar);

        jTabbedPane1.addTab("Nueva venta", paneNewVenta);
        jTabbedPane1.addTab("Modificar Clientes", paneModCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorAgregar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane paneModCliente;
    private javax.swing.JTabbedPane paneNewVenta;
    // End of variables declaration//GEN-END:variables

    
    private void agregarPaneles() {
        FormNuevaVenta form = new FormNuevaVenta(control);
        form.setBounds(0, 0, 930, 601 );
        contenedorAgregar.add(form);
        contenedorAgregar.updateUI();
    }
}
