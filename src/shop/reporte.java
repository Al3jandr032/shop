/*
 */
package shop;

import com.ipn.controllers.GeneradorTicket;
import com.ipn.model.beans.Carrito;
import com.ipn.model.beans.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class reporte {
       

        public static void main(String[] args) {
               Carrito c = new Carrito();
               Producto p = new Producto(12,"Coca","Refresco",10.00f,13,null);
               c.add(p,5);
               p = new Producto(12,"Indio","Cerveza",18.00f,12,null);
               c.add(p,3);
               GeneradorTicket t = new GeneradorTicket(c);
               t.generarTicket();
        }

        
        
}
