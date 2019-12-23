/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Grupa2
 */
@Entity
@Table(name = "odeljenja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odeljenja.findAll", query = "SELECT o FROM Odeljenja o")
    , @NamedQuery(name = "Odeljenja.findById", query = "SELECT o FROM Odeljenja o WHERE o.id = :odeljenjaId")
    , @NamedQuery(name = "Odeljenja.findByIme", query = "SELECT o FROM Odeljenja o WHERE o.ime = :ime")
    , @NamedQuery(name = "Odeljenja.findByUciteljiId", query = "SELECT o FROM Odeljenja o WHERE o.uciteljiId = :id")})
public class Odeljenja implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odeljenjaId")
    private List<Casovi> casoviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odeljenjaId")
    private List<Ucenici> uceniciList;
    @JoinColumn(name = "ucitelji_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ucitelji uciteljiId;

    public Odeljenja() {
    }

    public Odeljenja(Integer id) {
        this.id = id;
    }

    public Odeljenja(Integer id, String ime) {
        this.id = id;
        this.ime = ime;
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

    @XmlTransient
    public List<Casovi> getCasoviList() {
        return casoviList;
    }

    public void setCasoviList(List<Casovi> casoviList) {
        this.casoviList = casoviList;
    }

    @XmlTransient
    public List<Ucenici> getUceniciList() {
        return uceniciList;
    }

    public void setUceniciList(List<Ucenici> uceniciList) {
        this.uceniciList = uceniciList;
    }

    public Ucitelji getUciteljiId() {
        return uciteljiId;
    }

    public void setUciteljiId(Ucitelji uciteljiId) {
        this.uciteljiId = uciteljiId;
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
        if (!(object instanceof Odeljenja)) {
            return false;
        }
        Odeljenja other = (Odeljenja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Odeljenja[ id=" + id + " ]";
    }
    
}
