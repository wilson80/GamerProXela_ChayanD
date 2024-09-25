/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend.models;

/**
 *
 * @author Jonwil
 */
public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private String pasillo;
    private  String id;
    private int sucursal;
    private int cantidadBodega;
    private int cantidadExibicion;

    public Producto(String id, String descripcion, String nombre, double precio, String pasillo, int sucursal, int cantidadBodega, int cantidadExibicion) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.pasillo = pasillo;
        this.sucursal = sucursal;
        this.cantidadBodega = cantidadBodega;
        this.cantidadExibicion = cantidadExibicion;
    }

    
    
    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getCantidadExibicion() {
        return cantidadExibicion;
    }

    public void setCantidadExibicion(int cantidadExibicion) {
        this.cantidadExibicion = cantidadExibicion;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", pasillo=" + pasillo + ", sucursal=" + sucursal + ", cantidadBodega=" + cantidadBodega + ", cantidadExibicion=" + cantidadExibicion + '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
}
