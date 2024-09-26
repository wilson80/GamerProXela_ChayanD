/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jonwil
 */
public class PanelAdmin extends javax.swing.JPanel {
    private Control control;

    
    public PanelAdmin( Control control) {
        initComponents();
        this.control = control;
        agregarPaneles();
        control.setPanelAdmin(this);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        contenedorReport = new javax.swing.JPanel();
        currentConsulta = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contenedorReportes.add(jButton1);
        jButton1.setBounds(30, 80, 360, 39);

        jButton2.setText("Top 10 ventas más grandes en un intervalo de tiempo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        contenedorReportes.add(jButton2);
        jButton2.setBounds(30, 200, 353, 39);

        jButton3.setText("Top 2 sucursales que más dinero han ingresado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        contenedorReportes.add(jButton3);
        jButton3.setBounds(30, 340, 353, 39);

        jButton4.setText("Top 10 artículos más vendidos. ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        contenedorReportes.add(jButton4);
        jButton4.setBounds(30, 400, 353, 39);

        jButton5.setText("Top 10 clientes que más dinero han gastado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        contenedorReportes.add(jButton5);
        jButton5.setBounds(30, 460, 353, 39);

        contenedorReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorReport.setLayout(new java.awt.GridLayout(0, 1));
        contenedorReportes.add(contenedorReport);
        contenedorReport.setBounds(420, 50, 790, 550);

        currentConsulta.setText("Consulta actual: ");
        contenedorReportes.add(currentConsulta);
        currentConsulta.setBounds(470, 10, 490, 30);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        contenedorReportes.add(jSpinner1);
        jSpinner1.setBounds(90, 150, 80, 22);

        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        contenedorReportes.add(jSpinner2);
        jSpinner2.setBounds(210, 150, 90, 22);

        jSpinner3.setModel(new javax.swing.SpinnerDateModel());
        contenedorReportes.add(jSpinner3);
        jSpinner3.setBounds(90, 270, 80, 22);

        jSpinner4.setModel(new javax.swing.SpinnerDateModel());
        contenedorReportes.add(jSpinner4);
        jSpinner4.setBounds(210, 270, 90, 22);

        paneReportes.addTab("tab2", contenedorReportes);

        jTabbedPane1.addTab("Reportes", paneReportes);
        jTabbedPane1.addTab("Solicitudes Editar Cliente", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1375, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        contenedorReport.removeAll();

        control.identificarConsulta(2);
        currentConsulta.setText(" Top 10 ventas más grandes en un intervalo de tiempo");

    }//GEN-LAST:event_jButton2ActionPerformed

    public JPanel getContenedorReport() {
        return contenedorReport;
    }

    
    
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
          
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        contenedorReport.removeAll();
        control.identificarConsulta(3);// TODO add your handling code here:
        currentConsulta.setText("Top 2 sucursales que más dinero han ingresado");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        contenedorReport.removeAll();
        control.identificarConsulta(5); 
        currentConsulta.setText(" Top 10 clientes que más dinero han gastado");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                contenedorReport.removeAll();

        control.identificarConsulta(1);
        currentConsulta.setText("  Historial de descuentos realizados en un intervalo de tiempo.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        contenedorReport.removeAll();
        control.identificarConsulta(4);        // TODO add your handling code here:
        currentConsulta.setText(" Top 10 artículos más vendidos. ");

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorAgregar;
    private javax.swing.JPanel contenedorReport;
    private javax.swing.JPanel contenedorReportes;
    private javax.swing.JLabel currentConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane paneReportes;
    private javax.swing.JTabbedPane paneTarjetas;
    private javax.swing.JTabbedPane paneTrabajadores;
    // End of variables declaration//GEN-END:variables

    
    private void agregarPaneles() {
        FormNewTrabajador form = new FormNewTrabajador(control);
        form.setBounds(100, 0, 601, 700);
        contenedorAgregar.add(form);
        contenedorAgregar.updateUI();
    }
}
