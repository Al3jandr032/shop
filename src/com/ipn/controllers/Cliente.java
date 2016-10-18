/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.controllers;

import com.ipn.model.beans.Producto;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Cliente {
    private Socket clientSocket = null;
    private ObjectInputStream is = null;
    private ObjectOutputStream os = null;
    private FileInputStream entrada = null;
    private List<Producto> lst = null;
    
    public Cliente(String address, int port ) throws IOException {
        clientSocket = new Socket(address, port);
        this.os = new ObjectOutputStream(this.clientSocket.getOutputStream());
        this.is = new ObjectInputStream(this.clientSocket.getInputStream());
        System.out.println("Listo para recibir");
        
    }
    
    public List<Producto> recibirCatalogo() throws IOException, ClassNotFoundException{
        List<Producto> aux = null;
        int size=0;
        Producto p = null;
        System.out.println("Recibiendo catalogo");
        size = this.is.readInt();
        System.out.println("El tamaño del catalogo es: "+size);
        aux = new ArrayList();
        for(int i=0;i<size;i++){
            p = (Producto) this.is.readObject();
            aux.add(p);
        }
        return aux;
        
    }
    public int recvSize() throws IOException{
        System.out.println("recv size");
        int size = this.is.readInt();
        return size;
    }
}
