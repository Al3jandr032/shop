/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import com.ipn.controllers.Servidor;
import com.ipn.model.ProductoDao;
import com.ipn.model.beans.Producto;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Test {
    public static void main(String args[]){
        ProductoDao p = new ProductoDao();
        List<Producto> lst = null;
        Servidor s = null;
        lst = p.readAll();
        System.out.println("Numero de registros cargados : "+lst.size());
        try { 
                s = new Servidor(1921);
                s.EnviarProductos(lst);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
