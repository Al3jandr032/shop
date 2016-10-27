/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.model;

import com.ipn.model.beans.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Al3x
 */
public class ProductoDao implements ProductoDaoInterface {
    List<Producto> lst = null;
    @Override
    public void create(Producto p) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{        
        tx.begin();
        s.save(p);
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
    }

     @Override
    public void update(Producto p) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        s.update(p);
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
    }
    
    @Override
    public void delete(Producto p) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        s.delete(p);
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
    }
    @Override
    public Producto read(int id) {
        Producto p = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        p = (Producto) s.get(Producto.class, id);
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
        return p;
    }

    @Override
    public List readAll() {
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        lst =  s.createCriteria(Producto.class).list();
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
        
        return lst;
    }

    public byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
         
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
         
        return fileBytes;
    }

    @Override
    public void updateEx(int id, int ex) {
        int ex_actual;
        Producto p = null;
        Query query = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        tx.begin();
        /*
        p = (Producto) s.get(Producto.class, id);
      
        System.out.println("Existencia Actual :"+p.getExistencias());
        */
        query = s.createQuery("update Producto set Existencias = :existencia"
                + " where id = :id_p");
        query.setParameter("existencia", ex);
        query.setParameter("id_p", id);
        int result = query.executeUpdate();
        
        tx.commit();
       
    }

}
