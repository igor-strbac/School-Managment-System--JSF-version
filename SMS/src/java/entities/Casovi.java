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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "casovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casovi.findAll", query = "SELECT c FROM Casovi c")
    , @NamedQuery(name = "Casovi.findById", query = "SELECT c FROM Casovi c WHERE c.id = :id")
    , @NamedQuery(name = "Casovi.findByBroj", query = "SELECT c FROM Casovi c WHERE c.broj = :broj")
    , @NamedQuery(name = "Casovi.findByOdeljenje", query = "SELECT c FROM Casovi c WHERE c.odeljenjaId = :odeljenje")})
public class Casovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "broj")
    private int broj;
    @JoinColumn(name = "dani_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dani daniId;
    @JoinColumn(name = "odeljenja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Odeljenja odeljenjaId;
    @JoinColumn(name = "predmeti_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Predmeti predmetiId;

    public Casovi() {
    }

    public Casovi(Integer id) {
        this.id = id;
    }

    public Casovi(Integer id, int broj) {
        this.id = id;
        this.broj = broj;
    }
    
    public Casovi(int broj, Predmeti predmet, Dani dan, Odeljenja odeljenje) {
        this.broj = broj;
        this.predmetiId = predmet;
        this.daniId = dan;
        this.odeljenjaId = odeljenje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Dani getDaniId() {
        return daniId;
    }

    public void setDaniId(Dani daniId) {
        this.daniId = daniId;
    }

    public Odeljenja getOdeljenjaId() {
        return odeljenjaId;
    }

    public void setOdeljenjaId(Odeljenja odeljenjaId) {
        this.odeljenjaId = odeljenjaId;
    }

    public Predmeti getPredmetiId() {
        return predmetiId;
    }

    public void setPredmetiId(Predmeti predmetiId) {
        this.predmetiId = predmetiId;
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
        if (!(object instanceof Casovi)) {
            return false;
        }
        Casovi other = (Casovi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Casovi[ id=" + id + " ]";
    }
    
}
