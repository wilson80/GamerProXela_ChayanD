/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.backend.models;

/**
 *
 * @author Jonwil
 */
public class Usuario {
    private String cui;
    private String nombre;
    private String direccion;
    private String telefono;
//    private String fechaIngreso;
    private String nit;
    private int sucursalId;
    private String username;
    private String password;
    private String rol;

    public Usuario() {
    }

    public Usuario(String cui, String nombre, String direccion, String telefono, String nit, int sucursalId, String username, String password, String rol) {
        this.cui = cui;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.sucursalId = sucursalId;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    

   
    public String getNombre() {
        return nombre;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getUsername() {
        return username;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

  
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

 
    public String getRol() {
        return rol;
    }

 
    public void setRol(String rol) {
        this.rol = rol;
    }

   
//    public int getId() {
//        return id;
//    }
// 
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public String getFechaIngreso() {
//        return fechaIngreso;
//    }
//
//    public void setFechaIngreso(String fechaIngreso) {
//        this.fechaIngreso = fechaIngreso;
//    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }
    

}
