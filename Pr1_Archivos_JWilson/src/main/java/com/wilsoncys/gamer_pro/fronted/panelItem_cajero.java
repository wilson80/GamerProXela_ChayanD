/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted;

import com.wilsoncys.gamer_pro.backend.Control;
import com.wilsoncys.gamer_pro.backend.models.Producto;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class panelItem_cajero extends javax.swing.JPanel {
    private panel_Productos control;
    
    private String codigoP = "";
    private String nombre = "";
    private String descripcion = "";
    private double precio = 0;
    private int cantidad = 1;
    private int id;
    private boolean eliminado = false;
    private double subtotal;
    private int existencias;
    
    
    private Producto prod;
    
  
    public panelItem_cajero(panel_Productos control) {
        initComponents();
        this.control = control;
        labelCantidad.setText("Cantidad: " + cantidad);
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        labelCantidad = new javax.swing.JLabel();
        labelDesc = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelSubtotall = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelNombre.setText("nombre");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelCantidad.setText("cantidad");

        labelDesc.setText("descripcion");

        labelPrecio.setText("Precio");

        labelSubtotall.setText("Subtotal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelSubtotall, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(labelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSubtotall, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cantidad==1){
            eliminado = true;
            control.removerPanel(this);
            control.desAcumular(subtotal);
            JOptionPane.showMessageDialog(null, "Producto descartado ");
        } 
        cantidad--;
        labelCantidad.setText("Cantidad: " + cantidad);
        calcularSubtotal();
        control.quitarProd();
        control.desAcumular(subtotal);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cantidad++;
        
        if(cantidad>existencias){
            JOptionPane.showMessageDialog(null, "No se puede "
                                + "cubrir la cantidad Solicitada");
            cantidad--;
            labelCantidad.setText("Cantidad: " + cantidad);
            labelCantidad.setText("Cantidad: " + subtotal);
            control.quitarProd();
//            control.desAcumular(subtotal);
        }else{
            control.otroProd();
            labelCantidad.setText("Cantidad: " + cantidad);
            control.acumular(subtotal);
             calcularSubtotal();
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.labelNombre.setText("Nombre: " + nombre);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.labelPrecio.setText("Precio: " + precio );
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.labelDesc.setText("Descripcion: " + descripcion);
    }

    public void setProd(Producto prod) {
        this.prod = prod;
        setDescripcion(prod.getDescripcion());
        setPrecio(prod.getPrecio());
        setNombre(prod.getNombre());
        existencias = prod.getCantidadExibicion();
        calcularSubtotal();
    }
    
    
    public void calcularSubtotal(){
        subtotal = cantidad * precio; 
        labelSubtotall.setText("SubTotal: " + subtotal);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
        
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelDesc;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelSubtotall;
    // End of variables declaration//GEN-END:variables
}
