package business.sessionBeans;

import entities.Odeljenja;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OdeljenjaSessionBeanLocal {
    
    public List<Odeljenja> getOdeljenja();
}
