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
@Table(name = "maestroinventariocompleto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestroinventariocompleto.findAll", query = "SELECT m FROM Maestroinventariocompleto m")
    , @NamedQuery(name = "Maestroinventariocompleto.findByCodigo", query = "SELECT m FROM Maestroinventariocompleto m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Maestroinventariocompleto.findByDescripcion", query = "SELECT m FROM Maestroinventariocompleto m WHERE m.descripcion = :descripcion")})
public class Maestroinventariocompleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public Maestroinventariocompleto() {
    }

    public Maestroinventariocompleto(String codigo) {
        this.codigo = codigo;
    }

    public Maestroinventariocompleto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Maestroinventariocompleto)) {
            return false;
        }
        Maestroinventariocompleto other = (Maestroinventariocompleto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Maestroinventariocompleto[ codigo=" + codigo + " ]";
    }
    
}
