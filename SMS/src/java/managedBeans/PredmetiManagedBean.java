package managedBeans;

import business.sessionBeans.PredmetiSessionBeanLocal;
import entities.Predmeti;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

@ManagedBean(name ="predmetiMB")
@SessionScoped
public class PredmetiManagedBean implements Serializable{
    
    private String naziv;
    private Predmeti predmet;
    private HtmlDataTable tabelaPredmeti;
    
    private String dodavanjePoruka;
    private String brisanjePoruka;
    
    @EJB
    private PredmetiSessionBeanLocal predmetiBean;
            
    public List<Predmeti> getPredmeti() {
        return predmetiBean.getAllPredmeti();
    } 
    
    public void brisanjePredmeta() {
        predmet = (Predmeti) tabelaPredmeti.getRowData();
        
        if(predmetiBean.brisiPredmet(predmet.getId())) {
            brisanjePoruka = "Predmet uspešno obrisan!";
        }
        else {
           brisanjePoruka = "Greška prilikom brisnja predmeta!";
       }
        System.out.println(predmet.getId());
    }
    
    public void dodavanjePredmeta() {
        
       if(predmetiBean.dodajPredmet(naziv)!=true) {
           dodavanjePoruka = "Predmet verovatno već postoji u bazi!";
       }
       else {
           dodavanjePoruka = "Uspešno dodat predmet!";
       }
    }

    public HtmlDataTable getTabelaPredmeti() {
        return tabelaPredmeti;
    }

    public void setTabelaPredmeti(HtmlDataTable tabelaPredmeti) {
        this.tabelaPredmeti = tabelaPredmeti;
    }

    public Predmeti getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmeti predmet) {
        this.predmet = predmet;
    }

    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDodavanjePoruka() {
        return dodavanjePoruka;
    }

    public void setDodavanjePoruka(String dodavanjePoruka) {
        this.dodavanjePoruka = dodavanjePoruka;
    }

    public String getBrisanjePoruka() {
        return brisanjePoruka;
    }

    public void setBrisanjePoruka(String brisanjePoruka) {
        this.brisanjePoruka = brisanjePoruka;
    }
 
}
