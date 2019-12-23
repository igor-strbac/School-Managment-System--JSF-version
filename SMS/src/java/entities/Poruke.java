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
@Table(name = "poruke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poruke.findAll", query = "SELECT p FROM Poruke p")
    , @NamedQuery(name = "Poruke.findById", query = "SELECT p FROM Poruke p WHERE p.id = :id")
    , @NamedQuery(name = "Poruke.findByTekst", query = "SELECT p FROM Poruke p WHERE p.tekst = :tekst")})
public class Poruke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tekst")
    private String tekst;
    @JoinColumn(name = "roditelji_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roditelji roditeljiId;
    @JoinColumn(name = "ucitelji_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ucitelji uciteljiId;

    public Poruke() {
    }

    public Poruke(Integer id) {
        this.id = id;
    }

    public Poruke(Integer id, String tekst) {
        this.id = id;
        this.tekst = tekst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Roditelji getRoditeljiId() {
        return roditeljiId;
    }

    public void setRoditeljiId(Roditelji roditeljiId) {
        this.roditeljiId = roditeljiId;
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
        if (!(object instanceof Poruke)) {
            return false;
        }
        Poruke other = (Poruke) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Poruke[ id=" + id + " ]";
    }
    
}
