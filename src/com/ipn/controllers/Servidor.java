/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.controllers;

import com.ipn.model.beans.Producto;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Servidor {
    ServerSocket welcomeSocket;
    ObjectInputStream in;
    ObjectOutputStream out;
    private List<Producto> lst;
    
    public Servidor(int port) throws IOException{
        this.lst = null;
        welcomeSocket = new ServerSocket(port);
        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Conectado");
        out = new ObjectOutputStream(connectionSocket.getOutputStream());
        in = new ObjectInputStream(connectionSocket.getInputStream());

    }
    

    public void close() throws IOException {
        System.out.println("terminado");
        out.close();
        in.close();
    }
    public Producto RecibirDatosCompra(){
        
        return null;
    }
    
    public void EnviarProductos(List<Producto> p) throws IOException{
        System.out.println("tamaño de la lista :"+p.size());
        this.out.writeInt(p.size());
        this.out.flush();
        System.out.println("Enviado int");
        
        for(int i=0; i<p.size();i++){
            this.out.writeObject(p.get(i));
            this.out.flush();
        }
        this.out.writeInt(p.size());
        this.out.flush();
        for(int i=0; i<p.size();i++){
            this.enviarImagen(p.get(i).getPhoto());
        }
        
        System.out.println("Enviados objetos");
        
    }
    public void enviarImagen(byte[] imagen) throws FileNotFoundException, IOException{
        if (imagen != null) {
            byte[] buffer = imagen; // buffer
            int contador = 0;
            this.out.writeLong(imagen.length);
            this.out.flush();
            System.out.println("tamaño :"+imagen.length);
            
            while (contador < imagen.length) {
                //System.out.println(length);   
                if (imagen.length - contador < 1024) {
                    System.out.println("size : " + imagen.length + "  contador :" + contador);
                    int diff = imagen.length - contador;
                    System.out.println("menor " + diff);
                    this.out.write(buffer, contador, diff);
                    this.out.flush();
                    contador = contador + diff;
                } else {
                    this.out.write(buffer, contador, 1024);
                    this.out.flush();
                    contador = contador + 1024;
                }

            }

            System.out.println("Envio  imagen terminado");
        } else {
            this.out.writeLong(-1);
            this.out.flush();
        }
    }
    public List<Producto> getLst() {
        return lst;
    }

    public void setLst(List<Producto> lst) {
        this.lst = lst;
    }
    
}
