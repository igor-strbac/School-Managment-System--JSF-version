package managedBeans;

import business.sessionBeans.OceneSessionBeanLocal;
import entities.Ocene;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "oceneMB", eager = true)
@SessionScoped
public class OceneManagedBean implements Serializable{

    @EJB
    private OceneSessionBeanLocal oceneBean;   
    private Integer ucenik;
    private int odeljenje;
    private int predmet;
    
    public List<Ocene> getOceneUcenika(){
        setUcenik(1);
        return oceneBean.getOceneUcenika(getUcenik());
    }
    public Integer getUcenik() {
        return ucenik;
    }

    public void setUcenik(Integer ucenik) {
        this.ucenik = ucenik;
    }
    
       public List<Ocene> getAllOcenePoPredmetuOdeljenju() {
        
        return oceneBean.getOceneUcenikaPoPredmetuOdeljenju(3, 2);
    }
       
    public List<Ocene> getAllOcenePoPredmetu() {
        
        return oceneBean.getOceneUcenikaPoPredmetu(3);
    }
    
    public double getProsekPoPredmetuOdeljenju()
    {
        int brojOcena=0;
        int zbirOcena=0;
        double prosek;
        
        List<Ocene> ocene = oceneBean.getOceneUcenikaPoPredmetuOdeljenju(3, 2);
        
        for(Ocene o:ocene)
        {
            zbirOcena+=o.getOcena();
            brojOcena++;
        }
        
        prosek = (double)zbirOcena/brojOcena;
        
        return prosek;                  
        }
    
    public double getProsekPoPredmetu()
    {
        int brojOcena=0;
        int zbirOcena=0;
        double prosek;
        
        List<Ocene> ocene = oceneBean.getOceneUcenikaPoPredmetu(3);
        
        for(Ocene o:ocene)
        {
            zbirOcena+=o.getOcena();
            brojOcena++;
        }
        
        prosek = (double)zbirOcena/brojOcena;
        
        return prosek;                  
        }
}
