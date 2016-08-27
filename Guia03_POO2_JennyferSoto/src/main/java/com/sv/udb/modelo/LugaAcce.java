/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Owner
 */
@Entity
@Table(name = "luga_acce", catalog = "rceron_poo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugaAcce.findAll", query = "SELECT l FROM LugaAcce l WHERE l.esta = 1"),
    @NamedQuery(name = "LugaAcce.findByCodiLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.codiLugaAcce = :codiLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByNombLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.nombLugaAcce = :nombLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByFechAlta", query = "SELECT l FROM LugaAcce l WHERE l.fechAlta = :fechAlta"),
    @NamedQuery(name = "LugaAcce.findByFechBaja", query = "SELECT l FROM LugaAcce l WHERE l.fechBaja = :fechBaja"),
    @NamedQuery(name = "LugaAcce.findByEsta", query = "SELECT l FROM LugaAcce l WHERE l.esta = :esta")})
public class LugaAcce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_luga_acce")
    private Long codiLugaAcce;
    @Size(max = 100)
    @Column(name = "nomb_luga_acce")
    private String nombLugaAcce;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Column(name = "esta")
    private Integer esta;

    /**
     * Método constructor de la clase LugaAcce
     * No recibe parámetros
     */
    public LugaAcce() {
    }
    /**
     * Método constructor de la clase LugaAcce
     * @param codiLugaAcce Long llave primaria del objeto
     */
    public LugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }
    /**
     * Método Get de la llave primaria
     * No recibe parámetros
     */
    public Long getCodiLugaAcce() {
        return codiLugaAcce;
    }
    /**
     * Método set de la llave primaria
     * @param codiLugaAcce Long llave primaria del objeto
     */
    public void setCodiLugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }
    /**
     * Método get del nombre del objeto de clase LugaAcce
     */
    public String getNombLugaAcce() {
        return nombLugaAcce;
    }
    /**
     * Método set del nombre del objeto de clase LugaAcce
     * @param nombLugaAcce String nombre
     */
    public void setNombLugaAcce(String nombLugaAcce) {
        this.nombLugaAcce = nombLugaAcce;
    }
    /**
     * Método get de la fecha de inscripción del objeto de clase LugaAcce
     */
    public Date getFechAlta() {
        return fechAlta;
    }
    /**
     * Métido set de la fecha de inscripción del objeto de clase LugaAcce
     * @param fechAlta Date fecha de inscripción
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }
    /**
     * Método get de la fecha de baja del objeto de clase LugaAcce
     */
    public Date getFechBaja() {
        return fechBaja;
    }
    /**
     * Método set de la fecha de baja del objeto de clase LugaAcce
     * @param fechBaja Date fecha de baja
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }
    /**
     * Método get del estado del objeto de clase LugaAcce
     */
    public Integer getEsta() {
        return esta;
    }
    /**
     * Método set del estado del objeto de clase LugaAcce
     * @param esta int código de estado
     */
    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLugaAcce != null ? codiLugaAcce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugaAcce)) {
            return false;
        }
        LugaAcce other = (LugaAcce) object;
        if ((this.codiLugaAcce == null && other.codiLugaAcce != null) || (this.codiLugaAcce != null && !this.codiLugaAcce.equals(other.codiLugaAcce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.LugaAcce[ codiLugaAcce=" + codiLugaAcce + " ]";
    }
    
}
