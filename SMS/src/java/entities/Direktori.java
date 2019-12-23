/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupa2
 */
@Entity
@Table(name = "direktori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direktori.findAll", query = "SELECT d FROM Direktori d")
    , @NamedQuery(name = "Direktori.findById", query = "SELECT d FROM Direktori d WHERE d.id = :id")
    , @NamedQuery(name = "Direktori.findByIme", query = "SELECT d FROM Direktori d WHERE d.ime = :ime")
    , @NamedQuery(name = "Direktori.findByPrezime", query = "SELECT d FROM Direktori d WHERE d.prezime = :prezime")})
public class Direktori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezime")
    private String prezime;
    @JoinColumn(name = "korisnici_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Korisnici korisniciId;

    public Direktori() {
    }

    public Direktori(Integer id) {
        this.id = id;
    }

    public Direktori(Integer id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Korisnici getKorisniciId() {
        return korisniciId;
    }

    public void setKorisniciId(Korisnici korisniciId) {
        this.korisniciId = korisniciId;
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
        if (!(object instanceof Direktori)) {
            return false;
        }
        Direktori other = (Direktori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Direktori[ id=" + id + " ]";
    }
    
}
