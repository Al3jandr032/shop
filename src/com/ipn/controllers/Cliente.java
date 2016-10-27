/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.controllers;

import com.ipn.model.beans.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    public void recibirImagenes() throws FileNotFoundException, IOException{
        System.out.println("recibir imagenes");
         int size = this.is.readInt();
         System.out.println(size);
         long  fsize=0;
         int length;
         int contador = 0;
         for(int i=0;i<size;i++){
            System.out.println("leer imagen :"+i);
       
            fsize = is.readLong();
            System.out.println("size file: "+ fsize);
            if (fsize > 0) {
                File dest = new File("./" + "img" + i); // donde se guardan los archivos
                FileOutputStream salida = new FileOutputStream(dest); // buffer del archivo salida
                byte[] buffer = new byte[1024]; // buffer
                contador = 0;
                while (contador < fsize) {// para en el limite del archivo size
                    System.out.println("contador = " + contador);

                    if (fsize - contador < 1024) {
                        System.out.println("size : "+size+"  contador :"+contador);
                        long diff = fsize - contador;
                        System.out.println("menor " + diff);
                        buffer = new byte[(int)diff];
                    }

                    length = is.read(buffer);
                    System.out.println("leidos " + length);
                    contador = contador + length;

                    System.out.println("contador = " + contador + " despues");
                    System.out.println(length);
                    salida.write(buffer, 0, length);

                }
                salida.close();
            }
            System.out.println("termine una iteracion");

        }
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
            System.out.println("leer objeto :"+i);
            p = (Producto) this.is.readObject();
            aux.add(p);
        }
        return aux;
        
    }
   
}
