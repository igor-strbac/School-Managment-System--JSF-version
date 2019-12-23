package managedBeans;

import business.sessionBeans.DepartmentSessionBeanLocal;
import entities.Odeljenja;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "departmentMB", eager = true)
@SessionScoped
public class DepartmentManagedBean implements Serializable {
    
    @EJB
    private DepartmentSessionBeanLocal departmentBean; 
    
    public List<Odeljenja> getDepartments() {
        return departmentBean.getAllDepartments();
    }
}
