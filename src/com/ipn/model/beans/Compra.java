/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.model.beans;

/**
 *
 * @author Alejandro
 */
public class Compra {
    private int id_producto;
    private int cantidad;
    private int existencia;

    public Compra(int id_producto, int cantidad, int existencia) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.existencia = existencia;
    }

    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
}
