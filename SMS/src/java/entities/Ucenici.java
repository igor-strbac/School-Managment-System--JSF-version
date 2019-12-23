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

@Entity
@Table(name = "ucenici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucenici.findAll", query = "SELECT u FROM Ucenici u")
    , @NamedQuery(name = "Ucenici.findById", query = "SELECT u FROM Ucenici u WHERE u.id = :id")
    , @NamedQuery(name = "Ucenici.findByIme", query = "SELECT u FROM Ucenici u WHERE u.ime = :ime")
    , @NamedQuery(name = "Ucenici.findByPrezime", query = "SELECT u FROM Ucenici u WHERE u.prezime = :prezime")
    , @NamedQuery(name = "Ucenici.findUceniciByOdeljenje", query = "SELECT u FROM Ucenici u WHERE u.odeljenjaId = :odeljenja")})
public class Ucenici implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uceniciId")
    private List<Ocene> oceneList;
    @JoinColumn(name = "odeljenja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Odeljenja odeljenjaId;
    @JoinColumn(name = "roditelji_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roditelji roditeljiId;

    public Ucenici() {
    }

    public Ucenici(Integer id) {
        this.id = id;
    }

    public Ucenici(Integer id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Ucenici(String ime, String prezime, Odeljenja odeljenje, Roditelji roditelj) {
        this.ime = ime;
        this.prezime = prezime;
        this.odeljenjaId = odeljenje;
        this.roditeljiId = roditelj;
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
    public List<Ocene> getOceneList() {
        return oceneList;
    }

    public void setOceneList(List<Ocene> oceneList) {
        this.oceneList = oceneList;
    }

    public Odeljenja getOdeljenjaId() {
        return odeljenjaId;
    }

    public void setOdeljenjaId(Odeljenja odeljenjaId) {
        this.odeljenjaId = odeljenjaId;
    }

    public Roditelji getRoditeljiId() {
        return roditeljiId;
    }

    public void setRoditeljiId(Roditelji roditeljiId) {
        this.roditeljiId = roditeljiId;
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
        if (!(object instanceof Ucenici)) {
            return false;
        }
        Ucenici other = (Ucenici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ucenici[ id=" + id + " ]";
    }
    
}
