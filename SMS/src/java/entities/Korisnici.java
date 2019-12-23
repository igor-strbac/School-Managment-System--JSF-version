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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "korisnici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnici.findAll", query = "SELECT k FROM Korisnici k")
    , @NamedQuery(name = "Korisnici.findById", query = "SELECT k FROM Korisnici k WHERE k.id = :id")
    , @NamedQuery(name = "Korisnici.findByNalog", query = "SELECT k FROM Korisnici k WHERE k.nalog = :nalog")
    , @NamedQuery(name = "Korisnici.findByLozinka", query = "SELECT k FROM Korisnici k WHERE k.lozinka = :lozinka")
    , @NamedQuery(name = "Korisnici.findByStatus", query = "SELECT k FROM Korisnici k WHERE k.status = :status")
    , @NamedQuery(name = "Korisnici.findByNalogLozinkaStatus", query = "SELECT k FROM Korisnici k WHERE k.nalog = :nalog and k.lozinka= :lozinka and k.status = :status")
    , @NamedQuery(name = "Korisnici.findByUsernameAndPassword", query = "SELECT k FROM Korisnici k WHERE k.nalog = :nalog AND k.lozinka = :lozinka")})
public class Korisnici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nalog")
    private String nalog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lozinka")
    private String lozinka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisniciId")
    private List<Roditelji> roditeljiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisniciId")
    private List<Administratori> administratoriList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisniciId")
    private List<Direktori> direktoriList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisniciId")
    private List<Ucitelji> uciteljiList;

    public Korisnici() {
    }

    public Korisnici(Integer id) {
        this.id = id;
    }

    public Korisnici(Integer id, String nalog, String lozinka, int status) {
        this.id = id;
        this.nalog = nalog;
        this.lozinka = lozinka;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNalog() {
        return nalog;
    }

    public void setNalog(String nalog) {
        this.nalog = nalog;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Roditelji> getRoditeljiList() {
        return roditeljiList;
    }

    public void setRoditeljiList(List<Roditelji> roditeljiList) {
        this.roditeljiList = roditeljiList;
    }

    @XmlTransient
    public List<Administratori> getAdministratoriList() {
        return administratoriList;
    }

    public void setAdministratoriList(List<Administratori> administratoriList) {
        this.administratoriList = administratoriList;
    }

    @XmlTransient
    public List<Direktori> getDirektoriList() {
        return direktoriList;
    }

    public void setDirektoriList(List<Direktori> direktoriList) {
        this.direktoriList = direktoriList;
    }

    @XmlTransient
    public List<Ucitelji> getUciteljiList() {
        return uciteljiList;
    }

    public void setUciteljiList(List<Ucitelji> uciteljiList) {
        this.uciteljiList = uciteljiList;
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
        if (!(object instanceof Korisnici)) {
            return false;
        }
        Korisnici other = (Korisnici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Korisnici[ id=" + id + " ]";
    }
    
}
