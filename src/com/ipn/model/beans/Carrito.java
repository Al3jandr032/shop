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
    private  HashMap<Integer,Compra> dic;
    
    public Carrito() {
        dic =new HashMap<Integer,Compra>();
        productos = new ArrayList();
       
    }
    
    
    public void add(Producto p, Compra c){
        this.productos.add(p);
        this.dic.put(p.getId(), c);
        
    }
    public void remove(Producto p){
        dic.remove(p.getId());
        for(int i=0;i<this.productos.size();i++){
            if(p.getId() == this.productos.get(i).getId())
                this.productos.remove(i);
        }
    }
    
  
    
    public float getTotal() {
        float total = 0.0f;
        for (Producto p : this.productos){
            total = total + (p.getPrecio()*this.dic.get(p.getId()).getCantidad() );
        }
        return total;
    }

     public List<Producto> getProductos() {
        return productos;
    }

    
    public int getNumProdutos() {
        return this.productos.size();
    }

    public HashMap<Integer,Compra> getDic() {
        return dic;
    }

    public void setDic(HashMap<Integer,Compra> dic) {
        this.dic = dic;
    }

    
    
   
    
}
