/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;

/**
 *
 * @author Jonwil
 */
public class FormNuevaVenta extends javax.swing.JPanel {
    private Control control;

   
    public FormNuevaVenta(Control control) {
        initComponents();
        this.control = control;
        fieldNit.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldDireccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        checkNit = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        fieldNit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cantidadProd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 0)));
        setLayout(null);

        jLabel1.setText("Nombres y apellidos");
        add(jLabel1);
        jLabel1.setBounds(900, 90, 210, 30);

        jLabel2.setText("Direccion");
        add(jLabel2);
        jLabel2.setBounds(900, 160, 210, 30);

        fieldNombre.setText("Vicente fernadez");
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });
        add(fieldNombre);
        fieldNombre.setBounds(900, 120, 360, 40);

        fieldDireccion.setText("Xela");
        fieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDireccionActionPerformed(evt);
            }
        });
        add(fieldDireccion);
        fieldDireccion.setBounds(900, 200, 360, 30);

        jButton1.setText("Completar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(910, 520, 330, 40);

        Total.setText("Total:");
        add(Total);
        Total.setBounds(910, 420, 150, 40);

        checkNit.setText("Nit");
        checkNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNitActionPerformed(evt);
            }
        });
        add(checkNit);
        checkNit.setBounds(910, 290, 20, 20);

        jLabel3.setText("C/F (por defecto)");
        add(jLabel3);
        jLabel3.setBounds(910, 250, 100, 30);

        fieldNit.setText("123456454545");
        fieldNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNitActionPerformed(evt);
            }
        });
        add(fieldNit);
        fieldNit.setBounds(910, 330, 230, 40);

        jLabel7.setText("Informacion del cliente");
        add(jLabel7);
        jLabel7.setBounds(900, 60, 360, 40);

        cantidadProd.setText("Cantidad productos: ");
        add(cantidadProd);
        cantidadProd.setBounds(910, 380, 150, 40);

        jLabel4.setText("Ingresar Nit");
        add(jLabel4);
        jLabel4.setBounds(950, 290, 180, 16);

        jLabel5.setText("descuentos");
        add(jLabel5);
        jLabel5.setBounds(910, 470, 60, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDireccionActionPerformed

    private void checkNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNitActionPerformed
        if(checkNit.isSelected()){
            fieldNit.setEnabled(true);
        }else{
            fieldNit.setEnabled(false);
        }
    }//GEN-LAST:event_checkNitActionPerformed

    private void fieldNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JLabel cantidadProd;
    private javax.swing.JCheckBox checkNit;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldNit;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
