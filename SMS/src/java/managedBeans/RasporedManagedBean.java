package managedBeans;

import business.sessionBeans.CasoviSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "rasporedMB", eager = true)
@SessionScoped

public class RasporedManagedBean implements Serializable{
    
   private int brojCasa;
   private int predmet1;
   private int predmet2;
   private int predmet3;
   private int predmet4;
   private int predmet5;
   
   
   private int dan;
   private int odeljenje;
   private String poruka = "";
   
    @EJB
    private CasoviSessionBeanLocal casovi;
    
    public void kreirajraspored() {
        try {
        casovi.dodajRaspored(1, predmet1, dan, odeljenje);
        casovi.dodajRaspored(2, predmet2, dan, odeljenje);
        casovi.dodajRaspored(3, predmet3, dan, odeljenje);
        casovi.dodajRaspored(4, predmet4, dan, odeljenje);
        casovi.dodajRaspored(5, predmet5, dan, odeljenje);
        poruka = "Uspešno snimljen raspored!";
        }
        catch(Exception e){
            poruka = "Greška prilikom snimanja rasporeda!";
            e.printStackTrace();
        }
    }
    
    public void brisiRaspored(){
        casovi.brisiRaspored(odeljenje);
    }

    public int getBrojCasa() {
        return brojCasa;
    }

    public void setBrojCasa(int brojCasa) {
        this.brojCasa = brojCasa;
    }

    public int getPredmet1() {
        return predmet1;
    }

    public void setPredmet1(int predmet1) {
        this.predmet1 = predmet1;
    }

    public int getPredmet2() {
        return predmet2;
    }

    public void setPredmet2(int predmet2) {
        this.predmet2 = predmet2;
    }

    public int getPredmet3() {
        return predmet3;
    }

    public void setPredmet3(int predmet3) {
        this.predmet3 = predmet3;
    }

    public int getPredmet4() {
        return predmet4;
    }

    public void setPredmet4(int predmet4) {
        this.predmet4 = predmet4;
    }

    public int getPredmet5() {
        return predmet5;
    }

    public void setPredmet5(int predmet5) {
        this.predmet5 = predmet5;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(int odeljenje) {
        this.odeljenje = odeljenje;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
}
