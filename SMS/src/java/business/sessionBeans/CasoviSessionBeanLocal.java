package business.sessionBeans;

import entities.Casovi;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface CasoviSessionBeanLocal {
    
    public List<Casovi> getAllCasovi();
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void dodajRaspored(int broj, int predmet, int dan, int odeljenje);
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void brisiRaspored(int odeljenje);
}
