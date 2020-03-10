/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon
 */
@Entity
@Table(name = "centrodecostos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centrodecostos.findAll", query = "SELECT c FROM Centrodecostos c")
    , @NamedQuery(name = "Centrodecostos.findByCodigo", query = "SELECT c FROM Centrodecostos c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Centrodecostos.findByNombre", query = "SELECT c FROM Centrodecostos c WHERE c.nombre = :nombre")})
public class Centrodecostos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Centrodecostos() {
    }

    public Centrodecostos(String codigo) {
        this.codigo = codigo;
    }

    public Centrodecostos(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centrodecostos)) {
            return false;
        }
        Centrodecostos other = (Centrodecostos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Centrodecostos[ codigo=" + codigo + " ]";
    }
    
}
