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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "listadoterceros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listadoterceros.findAll", query = "SELECT l FROM Listadoterceros l")
    , @NamedQuery(name = "Listadoterceros.findById", query = "SELECT l FROM Listadoterceros l WHERE l.id = :id")
    , @NamedQuery(name = "Listadoterceros.findByTipo", query = "SELECT l FROM Listadoterceros l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Listadoterceros.findByCconit", query = "SELECT l FROM Listadoterceros l WHERE l.cconit = :cconit")
    , @NamedQuery(name = "Listadoterceros.findByNombre", query = "SELECT l FROM Listadoterceros l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Listadoterceros.findByDireccion", query = "SELECT l FROM Listadoterceros l WHERE l.direccion = :direccion")
    , @NamedQuery(name = "Listadoterceros.findByTelefono", query = "SELECT l FROM Listadoterceros l WHERE l.telefono = :telefono")})
public class Listadoterceros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cconit")
    private String cconit;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    public Listadoterceros() {
    }

    public Listadoterceros(Long id) {
        this.id = id;
    }

    public Listadoterceros(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCconit() {
        return cconit;
    }

    public void setCconit(String cconit) {
        this.cconit = cconit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listadoterceros)) {
            return false;
        }
        Listadoterceros other = (Listadoterceros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Listadoterceros[ id=" + id + " ]";
    }
    
}
