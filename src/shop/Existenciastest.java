/*
 */
package shop;

import com.ipn.model.ProductoDao;
import com.ipn.model.beans.Producto;

/**
 * @author Alejandro
 */
public class Existenciastest {
    public static void main(String args[]){
        ProductoDao p = new ProductoDao();
        Producto prod = new Producto(12,"pepsi","Refresco",10.00f,5,null);
        p.updateEx(prod.getId(), prod.getId());
    }
}
