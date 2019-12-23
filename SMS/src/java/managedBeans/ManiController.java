package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name = "maniMB", eager = true)
@SessionScoped
public class ManiController implements Serializable {
    
    private String mani;

    public void maniStatus()
    {
        System.out.println(mani);
    }
    
    public String getMani() {
        return mani;
    }

    public void setMani(String mani) {
        this.mani = mani;
    }
}
