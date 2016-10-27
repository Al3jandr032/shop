/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.model.beans;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Al3x
 */
@Entity
public class Producto implements Serializable{
    
    @Id
    private int id;
    private String Nombre;
    private String Descripcion;
    private float precio;
    private int existencias;
    private byte[] photo;

    public Producto(int id, String Nombre, String Descripcion, float precio, int existencias, byte[] photo) {
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.photo = photo;
    }
    
    public Producto(){
        this(0,"","",(float)0.0,0,null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
      @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.Nombre);
        hash = 47 * hash + Float.floatToIntBits(this.precio);
        hash = 47 * hash + this.existencias;
        return hash;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", precio=" + precio + ", existencias=" + existencias + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
}
