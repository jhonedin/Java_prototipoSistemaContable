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
@Table(name = "pucseiscostos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pucseiscostos.findAll", query = "SELECT p FROM Pucseiscostos p")
    , @NamedQuery(name = "Pucseiscostos.findByCodigo", query = "SELECT p FROM Pucseiscostos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pucseiscostos.findByNombre", query = "SELECT p FROM Pucseiscostos p WHERE p.nombre = :nombre")})
public class Pucseiscostos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Pucseiscostos() {
    }

    public Pucseiscostos(String codigo) {
        this.codigo = codigo;
    }

    public Pucseiscostos(String codigo, String nombre) {
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
        if (!(object instanceof Pucseiscostos)) {
            return false;
        }
        Pucseiscostos other = (Pucseiscostos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pucseiscostos[ codigo=" + codigo + " ]";
    }
    
}
