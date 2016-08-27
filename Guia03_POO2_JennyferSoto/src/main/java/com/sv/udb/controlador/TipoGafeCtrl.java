/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoGafe;
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
public class TipoGafeCtrl {
    /**
     * Método para guardar un tipo de gafete en la base de datos
     * @param obje TipoGafe objeto de tipo tipo de gafete
     * @return resp boolean true si ha sido guardado exitosamente
     */
    public boolean guar(TipoGafe obje)
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
     * Método para consultar todos los tipos de documentos en la base de datos
     * @return resp List lista de objetos de tipo TipoGafe
     */
    public List<TipoGafe>  ConsTodo()
    {
        List<TipoGafe> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<TipoGafe> query =em.createNamedQuery("TipoGafe.findAll", TipoGafe.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
    /**
     * Método para obtener un solo registro de la base de datos
     * @param empId Long llave primaria del registro que se desea obtener
     * @return resp TipoGafe objeto de tipo tipo de gafete con todos los datos del registro
     */
    public TipoGafe get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        TipoGafe resp = null;
        
        try{
            resp = em.find(TipoGafe.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
    /**
      * Método para modificar registros en la base de datos
      * @param obje TipoGafe objeto de tipo tipo de gafete
      * @return resp boolean true si ha sido modificado exitosamente
      */
    public boolean modi(TipoGafe obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PooPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoGafe lugar = null;
        tx.begin();
        try {
            lugar = em.find(TipoGafe.class, obje.getCodiTipoGafe());
            lugar.setNombTipoGafe(obje.getNombTipoGafe());
            tx.commit();
            resp = true;
        } catch (Exception ex) {
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
        TipoGafe lugar = null;
        tx.begin();
        try
        {
            
            lugar = em.find(TipoGafe.class, empId);
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
