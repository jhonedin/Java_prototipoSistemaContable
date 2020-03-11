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
@Table(name = "listadocostounitario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listadocostounitario.findAll", query = "SELECT l FROM Listadocostounitario l")
    , @NamedQuery(name = "Listadocostounitario.findByCodigokardex", query = "SELECT l FROM Listadocostounitario l WHERE l.codigokardex = :codigokardex")
    , @NamedQuery(name = "Listadocostounitario.findByCostounitario", query = "SELECT l FROM Listadocostounitario l WHERE l.costounitario = :costounitario")})
public class Listadocostounitario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigokardex")
    private String codigokardex;
    @Basic(optional = false)
    @Column(name = "costounitario")
    private int costounitario;

    public Listadocostounitario() {
    }

    public Listadocostounitario(String codigokardex) {
        this.codigokardex = codigokardex;
    }

    public Listadocostounitario(String codigokardex, int costounitario) {
        this.codigokardex = codigokardex;
        this.costounitario = costounitario;
    }

    public String getCodigokardex() {
        return codigokardex;
    }

    public void setCodigokardex(String codigokardex) {
        this.codigokardex = codigokardex;
    }

    public int getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(int costounitario) {
        this.costounitario = costounitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigokardex != null ? codigokardex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listadocostounitario)) {
            return false;
        }
        Listadocostounitario other = (Listadocostounitario) object;
        if ((this.codigokardex == null && other.codigokardex != null) || (this.codigokardex != null && !this.codigokardex.equals(other.codigokardex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Listadocostounitario[ codigokardex=" + codigokardex + " ]";
    }
    
}
