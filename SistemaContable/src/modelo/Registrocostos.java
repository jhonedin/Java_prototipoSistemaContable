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
@Table(name = "registrocostos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrocostos.findAll", query = "SELECT r FROM Registrocostos r")
    , @NamedQuery(name = "Registrocostos.findByNumregistro", query = "SELECT r FROM Registrocostos r WHERE r.numregistro = :numregistro")
    , @NamedQuery(name = "Registrocostos.findByAnioreg", query = "SELECT r FROM Registrocostos r WHERE r.anioreg = :anioreg")
    , @NamedQuery(name = "Registrocostos.findByMesreg", query = "SELECT r FROM Registrocostos r WHERE r.mesreg = :mesreg")
    , @NamedQuery(name = "Registrocostos.findByDiareg", query = "SELECT r FROM Registrocostos r WHERE r.diareg = :diareg")
    , @NamedQuery(name = "Registrocostos.findByNumidentificacion", query = "SELECT r FROM Registrocostos r WHERE r.numidentificacion = :numidentificacion")
    , @NamedQuery(name = "Registrocostos.findByNomtercero", query = "SELECT r FROM Registrocostos r WHERE r.nomtercero = :nomtercero")
    , @NamedQuery(name = "Registrocostos.findByCentrodecostos", query = "SELECT r FROM Registrocostos r WHERE r.centrodecostos = :centrodecostos")
    , @NamedQuery(name = "Registrocostos.findByCuentapuc", query = "SELECT r FROM Registrocostos r WHERE r.cuentapuc = :cuentapuc")
    , @NamedQuery(name = "Registrocostos.findByObservacion", query = "SELECT r FROM Registrocostos r WHERE r.observacion = :observacion")
    , @NamedQuery(name = "Registrocostos.findByValor", query = "SELECT r FROM Registrocostos r WHERE r.valor = :valor")})
public class Registrocostos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numregistro")
    private Long numregistro;
    @Basic(optional = false)
    @Column(name = "anioreg")
    private int anioreg;
    @Basic(optional = false)
    @Column(name = "mesreg")
    private int mesreg;
    @Basic(optional = false)
    @Column(name = "diareg")
    private int diareg;
    @Column(name = "numidentificacion")
    private String numidentificacion;
    @Column(name = "nomtercero")
    private String nomtercero;
    @Column(name = "centrodecostos")
    private String centrodecostos;
    @Column(name = "cuentapuc")
    private String cuentapuc;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;

    public Registrocostos() {
    }

    public Registrocostos(Long numregistro) {
        this.numregistro = numregistro;
    }

    public Registrocostos(Long numregistro, int anioreg, int mesreg, int diareg, int valor) {
        this.numregistro = numregistro;
        this.anioreg = anioreg;
        this.mesreg = mesreg;
        this.diareg = diareg;
        this.valor = valor;
    }

    public Long getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(Long numregistro) {
        this.numregistro = numregistro;
    }

    public int getAnioreg() {
        return anioreg;
    }

    public void setAnioreg(int anioreg) {
        this.anioreg = anioreg;
    }

    public int getMesreg() {
        return mesreg;
    }

    public void setMesreg(int mesreg) {
        this.mesreg = mesreg;
    }

    public int getDiareg() {
        return diareg;
    }

    public void setDiareg(int diareg) {
        this.diareg = diareg;
    }

    public String getNumidentificacion() {
        return numidentificacion;
    }

    public void setNumidentificacion(String numidentificacion) {
        this.numidentificacion = numidentificacion;
    }

    public String getNomtercero() {
        return nomtercero;
    }

    public void setNomtercero(String nomtercero) {
        this.nomtercero = nomtercero;
    }

    public String getCentrodecostos() {
        return centrodecostos;
    }

    public void setCentrodecostos(String centrodecostos) {
        this.centrodecostos = centrodecostos;
    }

    public String getCuentapuc() {
        return cuentapuc;
    }

    public void setCuentapuc(String cuentapuc) {
        this.cuentapuc = cuentapuc;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numregistro != null ? numregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrocostos)) {
            return false;
        }
        Registrocostos other = (Registrocostos) object;
        if ((this.numregistro == null && other.numregistro != null) || (this.numregistro != null && !this.numregistro.equals(other.numregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Registrocostos[ numregistro=" + numregistro + " ]";
    }
    
}
