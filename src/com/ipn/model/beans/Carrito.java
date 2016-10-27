/*
 */
package com.ipn.model.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Carrito {
    
    private List<Producto> productos;
    private  HashMap<Integer,Integer> dic;

   
    public Carrito() {
        dic =new HashMap<Integer,Integer>();
        productos = new ArrayList();
    }
    
    public void add(Producto p, int cantidad){
        this.productos.add(p);
        dic.put(p.getId(), cantidad);
    }
    public void remove(Producto p){
        dic.remove(p.getId());
        this.productos.remove(p);
    }
    
    public void update(Producto p, int cantidad){
        this.add(p, cantidad);
    }
    
    public float getTotal() {
        float total = 0.0f;
        for (Producto p : this.productos){
            total = total + (p.getPrecio()*this.dic.get(p.getId()) );
        }
        return total;
    }

     public List<Producto> getProductos() {
        return productos;
    }

    public HashMap<Integer, Integer> getDic() {
        return dic;
    }


    public int getNumProdutos() {
        return this.productos.size();
    }

   
    
}
