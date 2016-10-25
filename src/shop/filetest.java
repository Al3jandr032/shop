/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import com.ipn.model.ProductoDao;
import com.ipn.model.beans.Producto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class filetest {
    public static void main(String args[]){
        try {
            String path = "C:\\Users\\Alejandro\\Pictures\\git_logo.png";
            ProductoDao p = new ProductoDao();
            Producto prod = new Producto();
            
            prod.setNombre("Pepsi");
            prod.setPrecio((float) 12.45);
            prod.setDescripcion("refresco de cola");
            prod.setExistencias(12);
            byte[] photobytes = p.readBytesFromFile(path);
            
            prod.setPhoto(photobytes);
            System.out.println(prod.getPhoto().length);
            
            p.create(prod);
        } catch (IOException ex) {
            Logger.getLogger(filetest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
