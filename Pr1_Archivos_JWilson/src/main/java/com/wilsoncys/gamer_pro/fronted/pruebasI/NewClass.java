/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.fronted.pruebasI;

/**
 *
 * @author Jonwil
 */
    
import javax.swing.*;
import java.awt.*; 
  
  
    import javax.swing.*;
import java.awt.*;
 
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClass {
    // Contador para identificar los paneles agregados
    private static int contadorPaneles = 0;

    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Agregar Paneles Dinámicamente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        
        
        // Crear el panel principal con null layout
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(350, 50));  // Tamaño inicial

        // Crear un JScrollPane que contiene el panel con otros paneles dentro
        JScrollPane scrollPane = new JScrollPane(panelContenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Crear el botón para agregar paneles
        JButton botonAgregarPanel = new JButton("Agregar Panel");
        botonAgregarPanel.setBounds(10, 10, 150, 30);  // Posición del botón
        frame.add(botonAgregarPanel, BorderLayout.NORTH);

        
        
        // Listener para agregar paneles dinámicamente
        botonAgregarPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo panel
                JPanel nuevoPanel = new JPanel();
                nuevoPanel.setBackground(new Color(100 + contadorPaneles * 10, 100 + contadorPaneles * 15, 200 - contadorPaneles * 10));
                nuevoPanel.setBounds(10, 10 + (contadorPaneles * 80), 330, 70);  // Colocar panel en la siguiente posición
                nuevoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Borde para cada panel

                // Agregar el nuevo panel al contenedor
                panelContenedor.add(nuevoPanel);
                contadorPaneles++;

                // Ajustar el tamaño del contenedor según el número de paneles
                panelContenedor.setPreferredSize(new Dimension(350, 10 + (contadorPaneles * 80)));

                // Refrescar el contenedor para mostrar los nuevos paneles
                panelContenedor.revalidate();
                panelContenedor.repaint();
            }
        });

        
        
        // Agregar el JScrollPane al marco principal
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
