package managedBeans;

import business.sessionBeans.RegisterSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "registerMB", eager = true)
@SessionScoped
public class RegisterManagedBean implements Serializable {

    private String name;
    private String surname;
    private String username;
    private String password; 
    private int department;
    private int parent;
    private int user;
    
    private String messageU = "";
    private String messageS = "";
    
    @EJB
    private RegisterSessionBeanLocal registerBean;
    
    public boolean registerKorisnika() {
        
        boolean result = registerBean.registerKorisnika(name, surname, username, password, user);
        
        if (result==false) {
            messageU = "Greška prilikom registracije! Korisničko ime je verovatno zauzeto!";
        }
        if (user==0 && result==true) {
            messageU = "Uspešno ste registrivali novog admina!";
        }
        if (user==1 && result==true){
            messageU = "Uspešno ste registrivali novog direktora!";
        }
        if (user==2 && result==true){
            messageU = "Uspešno ste registrivali novog učitelja!";
        }
        if (user==3 && result==true) {
            messageU = "Uspešno ste registrivali novog roditelja!";
        }
        return result;
    }
    
    public boolean registerUcenika() {
        
        boolean result = registerBean.registerUcenika(name, surname, department, parent);
        if(result==true) {
            messageS = "Uspešno registrivan učenik!";
            return true;
        }
        messageS = "Greška prilikom registrivanja učenika!";
        return false;
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessageU() {
        return messageU;
    }

    public void setMessageU(String message) {
        this.messageU = messageU;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getMessageS() {
        return messageS;
    }

    public void setMessageS(String messageS) {
        this.messageS = messageS;
    }
    
}
