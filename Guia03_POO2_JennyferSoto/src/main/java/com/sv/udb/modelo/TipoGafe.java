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
@Table(name = "tipo_gafe", catalog = "rceron_poo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGafe.findAll", query = "SELECT t FROM TipoGafe t WHERE t.esta = 1"),
    @NamedQuery(name = "TipoGafe.findByCodiTipoGafe", query = "SELECT t FROM TipoGafe t WHERE t.codiTipoGafe = :codiTipoGafe"),
    @NamedQuery(name = "TipoGafe.findByNombTipoGafe", query = "SELECT t FROM TipoGafe t WHERE t.nombTipoGafe = :nombTipoGafe"),
    @NamedQuery(name = "TipoGafe.findByFechAlta", query = "SELECT t FROM TipoGafe t WHERE t.fechAlta = :fechAlta"),
    @NamedQuery(name = "TipoGafe.findByFechBaja", query = "SELECT t FROM TipoGafe t WHERE t.fechBaja = :fechBaja"),
    @NamedQuery(name = "TipoGafe.findByEsta", query = "SELECT t FROM TipoGafe t WHERE t.esta = :esta")})
public class TipoGafe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_tipo_gafe")
    private Long codiTipoGafe;
    @Size(max = 200)
    @Column(name = "nomb_tipo_gafe")
    private String nombTipoGafe;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Column(name = "esta")
    private Integer esta;

    /**
     * Método constructor de la clase
     * No requiere parámetros
     */
    public TipoGafe() {
    }
    /**
     * Método constructor de la clase
     * @param codiTipoGafe Long llave primera del objeto de clase TipoGafe
     */
    public TipoGafe(Long codiTipoGafe) {
        this.codiTipoGafe = codiTipoGafe;
    }
    /**
     * Método get de la llave primaria
     */
    public Long getCodiTipoGafe() {
        return codiTipoGafe;
    }
    /**
     * Método set de la llave primaria
     * @param codiTipoGafe Long llave primaria del objeto
     */
    public void setCodiTipoGafe(Long codiTipoGafe) {
        this.codiTipoGafe = codiTipoGafe;
    }
    /**
     * Método get del nombre del objeto de clase TipoGafe
     */
    public String getNombTipoGafe() {
        return nombTipoGafe;
    }
    /**
     * Método set del nombre del objeto de clase TipoGafe
     * @param nombTipoGafe String nombre del objeto
     */
    public void setNombTipoGafe(String nombTipoGafe) {
        this.nombTipoGafe = nombTipoGafe;
    }
    /**
     * Método get de la fecha de inscripción
     */
    public Date getFechAlta() {
        return fechAlta;
    }
    /**
     * Método set de la fecha de inscripción
     * @param fechAlta Date fecha
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }
    /**
     * Método get de la fecha de baja del objeto de clase TipoGafe
     */
    public Date getFechBaja() {
        return fechBaja;
    }
    /**
     * Método set de la fecha de baja del objeto de clase TipoGafe
     * @param fechBaja Date fecha
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }
    /**
     * Método get del estado del objeto
     */
    public Integer getEsta() {
        return esta;
    }
    /**
     * Método set del estado del objeto
     * @param esta int código del estado
     */
    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiTipoGafe != null ? codiTipoGafe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGafe)) {
            return false;
        }
        TipoGafe other = (TipoGafe) object;
        if ((this.codiTipoGafe == null && other.codiTipoGafe != null) || (this.codiTipoGafe != null && !this.codiTipoGafe.equals(other.codiTipoGafe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.TipoGafe[ codiTipoGafe=" + codiTipoGafe + " ]";
    }
    
}
