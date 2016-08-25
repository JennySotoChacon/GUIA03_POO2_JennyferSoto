/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoDocu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Owner
 */
public class TipoDocuCtrl {
    public boolean guar(TipoDocu obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    public List<TipoDocu>  ConsTodo()
    {
        List<TipoDocu> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<TipoDocu> query =em.createNamedQuery("TipoDocu.findAll", TipoDocu.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
    //Para conseguir un determinado registro
     public TipoDocu get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        TipoDocu resp = null;
        
        try{
            resp = em.find(TipoDocu.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
     
    public boolean modi(TipoDocu obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoDocu lugar = null;
        tx.begin();
        try {
            lugar = em.find(TipoDocu.class, obje.getCodiTipoDocu());
            lugar.setNombTipoDocu(obje.getNombTipoDocu());
            tx.commit();
            resp = true;
        } catch (Exception ex) {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
     public boolean elim(Long empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoDocu lugar = null;
        tx.begin();
        try
        {
            
            lugar = em.find(TipoDocu.class, empId);
            lugar.setEsta(0);
            lugar.setFechBaja(new Date());
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
}
