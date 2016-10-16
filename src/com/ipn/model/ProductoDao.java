/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.ipn.model;

import com.ipn.model.beans.Producto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Al3x
 */
public class ProductoDao implements ProductoDaoInterface {

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
    public Producto read(Producto p) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        p = (Producto) s.get(p.getClass(), p.getId());
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
        List<Producto> lst = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
        tx.begin();
        Query q =  s.createQuery("from Productos");
        lst = q.list();
        tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }
        
        return lst;
    }

    

   
    
}
