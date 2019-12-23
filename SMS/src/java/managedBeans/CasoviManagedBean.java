package managedBeans;

import business.sessionBeans.CasoviSessionBeanLocal;
import entities.Casovi;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="casoviMB")
@SessionScoped
public class CasoviManagedBean implements Serializable{
    
    @EJB
    private CasoviSessionBeanLocal casoviBean;
    
    public List<Casovi> getAllCasovi() {
        
        return casoviBean.getAllCasovi();
    }
}
