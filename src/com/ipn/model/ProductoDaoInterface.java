/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.model;

import com.ipn.model.beans.Producto;
import java.util.List;

/**
 *
 * @author Al3x
 */
public interface ProductoDaoInterface {
    public void create(Producto p);
    public Producto read(Producto p);
    public void update(Producto p);
    public List readAll();
    public void delete(Producto p);
    
}
