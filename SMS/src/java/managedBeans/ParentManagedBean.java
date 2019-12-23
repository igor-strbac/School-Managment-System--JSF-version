package managedBeans;

import business.sessionBeans.ParentSessionBeanLocal;
import entities.Roditelji;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "parentsMB", eager = true)
@SessionScoped
public class ParentManagedBean implements Serializable{
    
    @EJB
    private ParentSessionBeanLocal parentsBean;

    public List<Roditelji> getAllParents() {
        
        return parentsBean.getAllParents();        
    }
}
