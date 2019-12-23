package managedBeans;

import business.sessionBeans.DepartmentSessionBeanLocal;
import business.sessionBeans.StudentSessionBeanLocal;
import business.sessionBeans.UciteljiSessionBeanLocal;
import entities.Ucenici;
import entities.Ucitelji;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "studentMB", eager = true)
@SessionScoped
public class StudentManagedBean implements Serializable{
    
    private Integer odeljenje = null;
    private Integer ucenik = null;
    
    @EJB
    private StudentSessionBeanLocal studentBean;
    @EJB
    private DepartmentSessionBeanLocal departmentBean;
    @EJB
    private UciteljiSessionBeanLocal uciteljiBean;
    
//    @ManagedBean(value = "#{loginMB}")
//    private LoginManagedBean loginMB;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    LoginManagedBean loginMB = (LoginManagedBean)facesContext.getApplication()
      .createValueBinding("#{loginMB}").getValue(facesContext);
    
    public List<Ucenici> getAllStudents() {
        
        return studentBean.getAllStudents();
    }
        public List<Ucenici> getAllStudentsFromDepartment() {
        Ucitelji ucitelji = uciteljiBean.getUciteljByKorisniciId(loginMB.getLoggedInUser().getId());
        setOdeljenje(departmentBean.getDepartmentWhereUciteljiId(ucitelji.getId()).getId());
        return studentBean.getStudentsFromDepartment(getOdeljenje());
    }

    /**
     * @return the odeljenje
     */
    public Integer getOdeljenje() {
        return odeljenje;
    }

    /**
     * @param odeljenje the odeljenje to set
     */
    public void setOdeljenje(Integer odeljenje) {
        this.odeljenje = odeljenje;
    }

    /**
     * @return the ucenik
     */
    public Integer getUcenik() {
        return ucenik;
    }

    /**
     * @param ucenik the ucenik to set
     */
    public void setUcenik(Integer ucenik) {
        this.ucenik = ucenik;
    }
}
