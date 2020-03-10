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
@Table(name = "puccincogastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puccincogastos.findAll", query = "SELECT p FROM Puccincogastos p")
    , @NamedQuery(name = "Puccincogastos.findByCodigo", query = "SELECT p FROM Puccincogastos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Puccincogastos.findByNombre", query = "SELECT p FROM Puccincogastos p WHERE p.nombre = :nombre")})
public class Puccincogastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Puccincogastos() {
    }

    public Puccincogastos(String codigo) {
        this.codigo = codigo;
    }

    public Puccincogastos(String codigo, String nombre) {
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
        if (!(object instanceof Puccincogastos)) {
            return false;
        }
        Puccincogastos other = (Puccincogastos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Puccincogastos[ codigo=" + codigo + " ]";
    }
    
}
