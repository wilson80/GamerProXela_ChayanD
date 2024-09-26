/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import com.wilsoncys.gamer_pro.backend.database.usersdb.UsersDb;
import com.wilsoncys.gamer_pro.backend.models.Usuario;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Jonwil
 */
public class PanelLogin extends javax.swing.JPanel {
    private Control control;
    private principalWindow principalWin;


    /**
     * Creates new form PanelLogin
     */
    public PanelLogin(Control control) {
        initComponents();
        this.control = control;
        this.principalWin = control.principalWin;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUser = new javax.swing.JLabel();
        laberPassword = new javax.swing.JLabel();
        cajonUser = new javax.swing.JTextField();
        buttonEntrar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        cajonPassword = new javax.swing.JPasswordField();

        labelUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelUser.setText("Ingrese su usuario");

        laberPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        laberPassword.setText("Ingrese su constraseña");

        cajonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajonUserActionPerformed(evt);
            }
        });

        buttonEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Gamer Pro Sancris");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajonUser)
                            .addComponent(laberPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(labelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cajonPassword))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cajonPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajonUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajonUserActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        if(control.identificarUser(cajonUser.getText(), cajonPassword.getText())){
            ocultarVentana();
                       // Crear la ventana flotante
                JWindow ventanaFlotante = new JWindow();
                ventanaFlotante.setLayout(new BorderLayout());
                ventanaFlotante.setSize(300, 100);

                // Crear el mensaje
                JLabel mensaje = new JLabel("Inciando Secion.....", SwingConstants.CENTER);
                mensaje.setFont(new Font("Arial", Font.BOLD, 16));
                ventanaFlotante.add(mensaje, BorderLayout.CENTER);

                // Centrar la ventana flotante en la pantalla
                ventanaFlotante.setLocationRelativeTo(null);

                // Mostrar la ventana flotante
                ventanaFlotante.setVisible(true);

                // Programar la ventana para que desaparezca después de 3 segundos
                Timer temporizador = new Timer();
                temporizador.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ventanaFlotante.setVisible(false);
                        ventanaFlotante.dispose();  // Cerrar la ventana
                    }
                }, 1500); // 3000 milisegundos = 3 segundos
                
                control.inciarUser();
                control.principalWin.mostrar();
        }else{
            JOptionPane.showMessageDialog(principalWin, "No se reconoce el usuario o la contraseña es incorrecta");
        }
         
    }//GEN-LAST:event_buttonEntrarActionPerformed

//    public void iniciarElUsuario{
//        set
//    }
    
    public String getCajonPassword() {
        return cajonPassword.getText();
    }

    public String getCajonUser() {
        return cajonUser.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JPasswordField cajonPassword;
    private javax.swing.JTextField cajonUser;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel laberPassword;
    // End of variables declaration//GEN-END:variables

    private void ocultarVentana() {
        this.setVisible(false);
    }
 
    
}
