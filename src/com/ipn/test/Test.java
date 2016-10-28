/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.test;

import com.ipn.controllers.Servidor;
import com.ipn.model.ProductoDao;
import com.ipn.model.beans.Producto;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        int puerto = Integer.parseInt(JOptionPane.showInputDialog(null,"Puerto"));
        try { 
                s = new Servidor(puerto);
                s.EnviarProductos(lst);
                s.RecibirDatosCompra();
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
