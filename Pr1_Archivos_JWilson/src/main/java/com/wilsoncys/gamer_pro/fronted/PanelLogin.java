/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import com.wilsoncys.gamer_pro.backend.database.usersdb.UsersDb;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jonwil
 */
public class PanelLogin extends javax.swing.JPanel {
    private Control control;
    private principalWindow vPrincipal;


    /**
     * Creates new form PanelLogin
     */
    public PanelLogin(Control control) {
        initComponents();
        this.control = control;
        this.vPrincipal = control.vPrincipal;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUser = new javax.swing.JLabel();
        laberPassword = new javax.swing.JLabel();
        cajonPassword = new javax.swing.JTextField();
        cajonUser = new javax.swing.JTextField();
        buttonEntrar = new javax.swing.JButton();

        labelUser.setText("Ingrese su usuario");

        laberPassword.setText("Ingrese su constraseña");

        cajonPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajonPasswordActionPerformed(evt);
            }
        });

        cajonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajonUserActionPerformed(evt);
            }
        });

        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajonPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajonUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(laberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajonPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajonPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajonPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajonPasswordActionPerformed

    private void cajonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajonUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajonUserActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        if(control.identificarUser(cajonUser.getText(), cajonPassword.getText())){
            ocultarVentana();
        }
         
    }//GEN-LAST:event_buttonEntrarActionPerformed

    public String getCajonPassword() {
        return cajonPassword.getText();
    }

    public String getCajonUser() {
        return cajonUser.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JTextField cajonPassword;
    private javax.swing.JTextField cajonUser;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel laberPassword;
    // End of variables declaration//GEN-END:variables

    private void ocultarVentana() {
        this.setVisible(false);
    }
 
    
}
