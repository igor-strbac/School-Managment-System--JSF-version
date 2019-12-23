package managedBeans;

import business.sessionBeans.OdeljenjaSessionBeanLocal;
import entities.Odeljenja;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

@ManagedBean(name = "odeljenjaMB")
@SessionScoped
public class OdlejenjaManagedBean implements Serializable {
    
    private HtmlDataTable tabelaOdeljenja;
    private Odeljenja odeljenje;
    
    @EJB
    private OdeljenjaSessionBeanLocal odeljenjaBean; 
    
    public List<Odeljenja> allOdeljenja(){
         return odeljenjaBean.getOdeljenja();
    }
    
    public void ispis(){
        System.out.println(odeljenje);
    }

    public HtmlDataTable getTabelaOdeljenja() {
        return tabelaOdeljenja;
    }

    public void setTabelaOdeljenja(HtmlDataTable tabelaOdeljenja) {
        this.tabelaOdeljenja = tabelaOdeljenja;
    }

    public Odeljenja getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenja odeljenje) {
        this.odeljenje = odeljenje;
    }


    public void settabelaOdeljenja() {
        odeljenje = (Odeljenja) tabelaOdeljenja.getRowData();
    }
}
