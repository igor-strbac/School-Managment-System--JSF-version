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
@Table(name = "ucitelji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucitelji.findAll", query = "SELECT u FROM Ucitelji u")
    , @NamedQuery(name = "Ucitelji.findById", query = "SELECT u FROM Ucitelji u WHERE u.id = :id")
    , @NamedQuery(name = "Ucitelji.findByIme", query = "SELECT u FROM Ucitelji u WHERE u.ime = :ime")
    , @NamedQuery(name = "Ucitelji.findByPrezime", query = "SELECT u FROM Ucitelji u WHERE u.prezime = :prezime")
    , @NamedQuery(name = "Ucitelji.findByKorisniciId", query = "SELECT u FROM Ucitelji u WHERE u.korisniciId = :id")})
public class Ucitelji implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uciteljiId")
    private List<Odeljenja> odeljenjaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uciteljiId")
    private List<Poruke> porukeList;
    @JoinColumn(name = "korisnici_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Korisnici korisniciId;

    public Ucitelji() {
    }

    public Ucitelji(Integer id) {
        this.id = id;
    }

    public Ucitelji(Integer id, String ime, String prezime) {
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

    @XmlTransient
    public List<Odeljenja> getOdeljenjaList() {
        return odeljenjaList;
    }

    public void setOdeljenjaList(List<Odeljenja> odeljenjaList) {
        this.odeljenjaList = odeljenjaList;
    }

    @XmlTransient
    public List<Poruke> getPorukeList() {
        return porukeList;
    }

    public void setPorukeList(List<Poruke> porukeList) {
        this.porukeList = porukeList;
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
        if (!(object instanceof Ucitelji)) {
            return false;
        }
        Ucitelji other = (Ucitelji) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ucitelji[ id=" + id + " ]";
    }
    
}
