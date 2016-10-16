/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import com.ipn.model.ProductoDao;
import com.ipn.model.beans.Producto;

/**
 *
 * @author Al3x
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductoDao p = new ProductoDao();
        Producto producto = new Producto();
        producto.setId(124);
        producto.setNombre("Coca-cola");
        producto.setDescripcion("refresco de cola");
        producto.setExistencias(12);
        producto.setPrecio((float) 10.00);
        p.create(producto);
        System.out.println("Hola mundo");
    }
    
}
