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
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "ocene")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocene.findAll", query = "SELECT o FROM Ocene o")
    , @NamedQuery(name = "Ocene.findById", query = "SELECT o FROM Ocene o WHERE o.id = :id")
    , @NamedQuery(name = "Ocene.findByOcena", query = "SELECT o FROM Ocene o WHERE o.ocena = :ocena")
    , @NamedQuery(name = "Ocene.findByZakljucna", query = "SELECT o FROM Ocene o WHERE o.zakljucna = :zakljucna")
    , @NamedQuery(name = "Ocene.findByUcenik", query = "SELECT o FROM Ocene o WHERE o.uceniciId = :ucenik")
    , @NamedQuery(name = "Ocene.findByPredmet", query = "SELECT o FROM Ocene o WHERE o.predmetiId.id = :predmetiId")
    , @NamedQuery(name = "Ocene.findByOdeljenjePredmet", query = "SELECT o FROM Ocene o INNER JOIN o.uceniciId u "
            + "WHERE o.predmetiId.id= :predmetiId and u.odeljenjaId.id= :odeljenjaId")
})
public class Ocene implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ocena")
    private Integer ocena;
    @Column(name = "zakljucna")
    private Integer zakljucna;
    @JoinColumn(name = "predmeti_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Predmeti predmetiId;
    @JoinColumn(name = "ucenici_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ucenici uceniciId;

    public Ocene() {
    }

    public Ocene(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Integer getZakljucna() {
        return zakljucna;
    }

    public void setZakljucna(Integer zakljucna) {
        this.zakljucna = zakljucna;
    }

    public Predmeti getPredmetiId() {
        return predmetiId;
    }

    public void setPredmetiId(Predmeti predmetiId) {
        this.predmetiId = predmetiId;
    }

    public Ucenici getUceniciId() {
        return uceniciId;
    }

    public void setUceniciId(Ucenici uceniciId) {
        this.uceniciId = uceniciId;
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
        if (!(object instanceof Ocene)) {
            return false;
        }
        Ocene other = (Ocene) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ocene[ id=" + id + " ]";
    }
    
}
