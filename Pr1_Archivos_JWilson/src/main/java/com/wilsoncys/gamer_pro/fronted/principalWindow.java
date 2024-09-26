/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Jonwil
 */
public class principalWindow extends javax.swing.JFrame {
    
    private Control control;
    private Usuario userActual;
    
    
    
    public principalWindow(Control control) {
        initComponents();
        this.control = control;
        insertarVentanaLogig();
        ocultar();
        
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        labelSucursal = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGeneral.setLayout(null);

        buttonLogOut.setText("cerrarSesion");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        labelSucursal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        labelPuesto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("Gamer Pro SanCris");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(labelPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                        .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonLogOut)
                        .addComponent(jLabel1))
                    .addComponent(labelPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
         logoutSecion( );
        
    }//GEN-LAST:event_buttonLogOutActionPerformed
    public void ocultar(){
        buttonLogOut.setVisible(false);
    }
    
    public void mostrar(){
        buttonLogOut.setVisible(true);
    }

    public void logoutSecion( ){
        labelPuesto.setText("");
        labelSucursal.setText("");
        
        panelGeneral.removeAll();
        insertarVentanaLogig();
    }
   
    public void addThePanelGeneral(Component component, Usuario userActual){
        String sucursal = "";
        panelGeneral.add(component);
        this.userActual = userActual;
        labelPuesto.setText("Usuario actual: " + userActual.getRol());
        switch (userActual.getSucursalId()) {
            case 1:
                sucursal = "Parque";
                break;
            case 2:
                sucursal = "Centro 1";
                break;
            case 3:
                sucursal = " Centro 2";
                break;
            default:
                break;
                
        }
        
        labelSucursal.setText("Sucursal: " + sucursal);
        panelGeneral.updateUI();
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JLabel labelSucursal;
    private javax.swing.JPanel panelGeneral;
    // End of variables declaration//GEN-END:variables

    private void insertarVentanaLogig() {
        
        PanelLogin paneLog = new PanelLogin(control);
        paneLog.setBounds(470, 110, 680, 470); // Establecer las coordenadas y el tamaño del panel secundario
        panelGeneral.add(paneLog);
        panelGeneral.updateUI();
    }

    public void setUserActual(Usuario userActual) {
        this.userActual = userActual;
    }
    
    
    
    
}
