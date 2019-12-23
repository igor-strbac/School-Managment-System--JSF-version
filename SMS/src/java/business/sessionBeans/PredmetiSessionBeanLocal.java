package business.sessionBeans;

import entities.Predmeti;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface PredmetiSessionBeanLocal {

    public List<Predmeti> getAllPredmeti();   
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean dodajPredmet(String naziv);
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean brisiPredmet(int pr);
}
