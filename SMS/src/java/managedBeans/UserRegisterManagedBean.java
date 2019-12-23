package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userBean", eager = true)
@SessionScoped
public class UserRegisterManagedBean implements Serializable{
    
    private String user;

    private void pisi() {
        System.out.println("Prijavljeni korisnik: "+user);
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
