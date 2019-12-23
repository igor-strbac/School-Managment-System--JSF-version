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

/**
 *
 * @author Grupa2
 */
@Entity
@Table(name = "predmeti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmeti.findAll", query = "SELECT p FROM Predmeti p")
    , @NamedQuery(name = "Predmeti.findById", query = "SELECT p FROM Predmeti p WHERE p.id = :id")
    , @NamedQuery(name = "Predmeti.findByIme", query = "SELECT p FROM Predmeti p WHERE p.ime = :ime")
    , @NamedQuery(name = "Predmeti.deleteById", query = "DELETE FROM Predmeti p WHERE p.id = :pr")})
public class Predmeti implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmetiId")
    private List<Casovi> casoviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmetiId")
    private List<Ocene> oceneList;

    public Predmeti() {
    }

    public Predmeti(Integer id) {
        this.id = id;
    }

    public Predmeti(Integer id, String ime) {
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
    public List<Ocene> getOceneList() {
        return oceneList;
    }

    public void setOceneList(List<Ocene> oceneList) {
        this.oceneList = oceneList;
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
        if (!(object instanceof Predmeti)) {
            return false;
        }
        Predmeti other = (Predmeti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Predmeti[ id=" + id + " ]";
    }
    
}
