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
@Table(name = "registroingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroingresos.findAll", query = "SELECT r FROM Registroingresos r")
    , @NamedQuery(name = "Registroingresos.findByNumregistro", query = "SELECT r FROM Registroingresos r WHERE r.numregistro = :numregistro")
    , @NamedQuery(name = "Registroingresos.findByAnioreg", query = "SELECT r FROM Registroingresos r WHERE r.anioreg = :anioreg")
    , @NamedQuery(name = "Registroingresos.findByMesreg", query = "SELECT r FROM Registroingresos r WHERE r.mesreg = :mesreg")
    , @NamedQuery(name = "Registroingresos.findByDiareg", query = "SELECT r FROM Registroingresos r WHERE r.diareg = :diareg")
    , @NamedQuery(name = "Registroingresos.findByNumidentificacion", query = "SELECT r FROM Registroingresos r WHERE r.numidentificacion = :numidentificacion")
    , @NamedQuery(name = "Registroingresos.findByNomtercero", query = "SELECT r FROM Registroingresos r WHERE r.nomtercero = :nomtercero")
    , @NamedQuery(name = "Registroingresos.findByCuentapuc", query = "SELECT r FROM Registroingresos r WHERE r.cuentapuc = :cuentapuc")
    , @NamedQuery(name = "Registroingresos.findByCodigokardex", query = "SELECT r FROM Registroingresos r WHERE r.codigokardex = :codigokardex")
    , @NamedQuery(name = "Registroingresos.findByObservacion", query = "SELECT r FROM Registroingresos r WHERE r.observacion = :observacion")
    , @NamedQuery(name = "Registroingresos.findByValor", query = "SELECT r FROM Registroingresos r WHERE r.valor = :valor")})
public class Registroingresos implements Serializable {

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
    @Column(name = "cuentapuc")
    private String cuentapuc;
    @Column(name = "codigokardex")
    private String codigokardex;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;

    public Registroingresos() {
    }

    public Registroingresos(Long numregistro) {
        this.numregistro = numregistro;
    }

    public Registroingresos(Long numregistro, int valor) {
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

    public String getCuentapuc() {
        return cuentapuc;
    }

    public void setCuentapuc(String cuentapuc) {
        this.cuentapuc = cuentapuc;
    }

    public String getCodigokardex() {
        return codigokardex;
    }

    public void setCodigokardex(String codigokardex) {
        this.codigokardex = codigokardex;
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
        if (!(object instanceof Registroingresos)) {
            return false;
        }
        Registroingresos other = (Registroingresos) object;
        if ((this.numregistro == null && other.numregistro != null) || (this.numregistro != null && !this.numregistro.equals(other.numregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Registroingresos[ numregistro=" + numregistro + " ]";
    }
    
}
