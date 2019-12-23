/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupa1
 */
@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable{

    /**
     * Creates a new instance of NavigationController
     */
    public NavigationController() {
    }
    
    public String moveToAdmin(){
        return "admin";   
    }
    public String moveToAdminDepartments(){
        return "adminDepartments";
    }
    public String moveToDirector(){
        return "director";
    }
    public String moveToIndex(){
        return "index";
    }
    public String moveToPoruke(){
        return "poruke";
    }
    public String moveToRegister(){
        return "register";
    }
    public String moveToUceniciOdeljenja(){
        return "uceniciOdeljenja";
    }
    public String moveToUcenik(){
        return "ucenik";
    }
    public String moveToUcitelji(){
        return "ucitelji";
    }
}
