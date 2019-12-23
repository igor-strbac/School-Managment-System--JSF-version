package managedBeans;

import business.sessionBeans.UciteljiSessionBeanLocal;
import entities.Ucitelji;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "uciteljiManagedBean", eager = true)
@SessionScoped
public class UciteljiManagedBean implements Serializable{
    private int ocena;
    
    @EJB
    private UciteljiSessionBeanLocal uciteljiBean;
    
    public List<Ucitelji> getUcitelji() {
        
        return uciteljiBean.getAllUcitelji();
    }
}