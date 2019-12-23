package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import business.sessionBeans.LoginSessionBeanLocal;
import entities.Korisnici;
import javax.ejb.EJB;

@ManagedBean(name = "loginMB", eager = true)
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String username;
    private String password;
    private int user;
    

    private String message = "";

    private Korisnici loggedInUser = null;

    @EJB
    private LoginSessionBeanLocal loginBean;
    
    
    public int login() {
        Korisnici korisnici = loginBean.login(username, password, user);
        
        loggedInUser = korisnici;
        
        if (loggedInUser != null) {
            return user;
        }
        
        else if (loggedInUser == null) {
            message = "Neispravna kombinacija korisničkog imena, lozinke ili statusa.";
            return 4;
        }
  
        return user;
    }
    
    
    public void logout() {
        loggedInUser = null;
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

    public Korisnici getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Korisnici loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public boolean isLoggedIn() {
        return (loggedInUser != null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    
}
