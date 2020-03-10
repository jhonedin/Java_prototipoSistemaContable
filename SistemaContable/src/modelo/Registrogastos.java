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
@Table(name = "registrogastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrogastos.findAll", query = "SELECT r FROM Registrogastos r")
    , @NamedQuery(name = "Registrogastos.findByNumregistro", query = "SELECT r FROM Registrogastos r WHERE r.numregistro = :numregistro")
    , @NamedQuery(name = "Registrogastos.findByAnioreg", query = "SELECT r FROM Registrogastos r WHERE r.anioreg = :anioreg")
    , @NamedQuery(name = "Registrogastos.findByMesreg", query = "SELECT r FROM Registrogastos r WHERE r.mesreg = :mesreg")
    , @NamedQuery(name = "Registrogastos.findByDiareg", query = "SELECT r FROM Registrogastos r WHERE r.diareg = :diareg")
    , @NamedQuery(name = "Registrogastos.findByNumidentificacion", query = "SELECT r FROM Registrogastos r WHERE r.numidentificacion = :numidentificacion")
    , @NamedQuery(name = "Registrogastos.findByNomtercero", query = "SELECT r FROM Registrogastos r WHERE r.nomtercero = :nomtercero")
    , @NamedQuery(name = "Registrogastos.findByCentrodecostos", query = "SELECT r FROM Registrogastos r WHERE r.centrodecostos = :centrodecostos")
    , @NamedQuery(name = "Registrogastos.findByCuentapuc", query = "SELECT r FROM Registrogastos r WHERE r.cuentapuc = :cuentapuc")
    , @NamedQuery(name = "Registrogastos.findByObservacion", query = "SELECT r FROM Registrogastos r WHERE r.observacion = :observacion")
    , @NamedQuery(name = "Registrogastos.findByValor", query = "SELECT r FROM Registrogastos r WHERE r.valor = :valor")})
public class Registrogastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numregistro")
    private Long numregistro;
    @Column(name = "anioreg")
    private Integer anioreg;
    @Column(name = "mesreg")
    private Integer mesreg;
    @Column(name = "diareg")
    private Integer diareg;
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

    public Registrogastos() {
    }

    public Registrogastos(Long numregistro) {
        this.numregistro = numregistro;
    }

    public Registrogastos(Long numregistro, int valor) {
        this.numregistro = numregistro;
        this.valor = valor;
    }

    public Long getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(Long numregistro) {
        this.numregistro = numregistro;
    }

    public Integer getAnioreg() {
        return anioreg;
    }

    public void setAnioreg(Integer anioreg) {
        this.anioreg = anioreg;
    }

    public Integer getMesreg() {
        return mesreg;
    }

    public void setMesreg(Integer mesreg) {
        this.mesreg = mesreg;
    }

    public Integer getDiareg() {
        return diareg;
    }

    public void setDiareg(Integer diareg) {
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
        if (!(object instanceof Registrogastos)) {
            return false;
        }
        Registrogastos other = (Registrogastos) object;
        if ((this.numregistro == null && other.numregistro != null) || (this.numregistro != null && !this.numregistro.equals(other.numregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Registrogastos[ numregistro=" + numregistro + " ]";
    }
    
}
