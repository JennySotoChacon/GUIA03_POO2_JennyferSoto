/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.LugaAcce;
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
public class LugaAcceCtrl {
    /**
     * Método para guardar un lugar de acceso en la base de datos
     * @param obje LugaAcce objeto de tipo lugar de acceso
     * @return resp boolean true si ha sido guardado exitosamente
     */
    public boolean guar(LugaAcce obje)
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
    /**
     * Método para consultar todos los lugares de accesos en la base de datos
     * @return resp List lista de objetos de tipo LugaAcce
     */
    
    public List<LugaAcce>  ConsTodo()
    {
        List<LugaAcce> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<LugaAcce> query = em.createNamedQuery("LugaAcce.findAll", LugaAcce.class);
            resp = query.getResultList();
        } catch (Exception ex) {

        }
        return resp;
       
    }
    /**
     * Método para obtener un solo registro de la base de datos
     * @param empId Long llave primaria del registro que se desea obtener
     * @return resp LugaAcce objeto de tipo lugar de acceso con todos los datos del registro
     */
     public LugaAcce get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        LugaAcce resp = null;
        
        try{
            resp = em.find(LugaAcce.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
     /**
      * Método para modificar registros en la base de datos
      * @param obje LugaAcce objeto de tipo lugar de acceso
      * @return resp boolean true si ha sido modificado exitosamente
      */
     public boolean modi(LugaAcce obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
         LugaAcce lugar = null;
        tx.begin();
        try
        {
            lugar = em.find(LugaAcce.class, obje.getCodiLugaAcce());
            lugar.setNombLugaAcce(obje.getNombLugaAcce());
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
     /**
      * Método para dar de baja registros actualizando su estado
      * @param empId Long llave primaria del registro a modificar
      * @return resp boolean true si ha sido eliminado exitosamente
      */
     public boolean elim(Long empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        LugaAcce lugar = null;
        tx.begin();
        try
        {
            
            lugar = em.find(LugaAcce.class, empId);
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
