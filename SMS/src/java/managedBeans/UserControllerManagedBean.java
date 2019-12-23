package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userBean", eager=true)
@SessionScoped
public class UserControllerManagedBean implements Serializable{
    
    private int user;

    public int getUser() {
        return user;
    }
    
    public void pisi()
    {
        System.out.println(user);
    }

    public void setUser(int user) {
        this.user = user;
    }
}
