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
public class panelAdmin extends javax.swing.JPanel {
    private Control control;

    /**
     * Creates new form panelAdmin
     */
    public panelAdmin( Control control) {
        initComponents();
        this.control = control;
        agregarPaneles();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        paneTrabajadores = new javax.swing.JTabbedPane();
        contenedorAgregar = new javax.swing.JPanel();
        paneTarjetas = new javax.swing.JTabbedPane();
        paneReportes = new javax.swing.JTabbedPane();
        contenedorReportes = new javax.swing.JPanel();
        seleccionReporte = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        contenedorAgregar.setLayout(null);
        paneTrabajadores.addTab("Agregar Trabajadores", contenedorAgregar);

        jTabbedPane1.addTab("Agregar Trabajadores", paneTrabajadores);
        jTabbedPane1.addTab("Gestionar Tarjetas", paneTarjetas);

        contenedorReportes.setLayout(null);

        jButton1.setText(" Historial de descuentos realizados en un intervalo de tiempo.");

        jButton2.setText("Top 10 ventas más grandes en un intervalo de tiempo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Top 2 sucursales que más dinero han ingresado");

        jButton4.setText("Top 10 artículos más vendidos. ");

        jButton5.setText("Top 10 clientes que más dinero han gastado");

        javax.swing.GroupLayout seleccionReporteLayout = new javax.swing.GroupLayout(seleccionReporte);
        seleccionReporte.setLayout(seleccionReporteLayout);
        seleccionReporteLayout.setHorizontalGroup(
            seleccionReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccionReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seleccionReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        seleccionReporteLayout.setVerticalGroup(
            seleccionReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccionReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        contenedorReportes.add(seleccionReporte);
        seleccionReporte.setBounds(260, 140, 380, 452);

        paneReportes.addTab("tab2", contenedorReportes);

        jTabbedPane1.addTab("Reportes", paneReportes);
        jTabbedPane1.addTab("Solicitudes Editar Cliente", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
          
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorAgregar;
    private javax.swing.JPanel contenedorReportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane paneReportes;
    private javax.swing.JTabbedPane paneTarjetas;
    private javax.swing.JTabbedPane paneTrabajadores;
    private javax.swing.JPanel seleccionReporte;
    // End of variables declaration//GEN-END:variables

    
    private void agregarPaneles() {
        FormNewTrabajador form = new FormNewTrabajador(control);
        form.setBounds(100, 0, 601, 700);
        contenedorAgregar.add(form);
        contenedorAgregar.updateUI();
    }
}
