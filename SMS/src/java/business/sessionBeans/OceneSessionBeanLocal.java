package business.sessionBeans;

import entities.Ocene;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
@Local
public interface OceneSessionBeanLocal {
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Ocene> getOceneUcenika(Integer ucenik);
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Ocene> getOceneUcenikaPoPredmetuOdeljenju(int predmet, int odeljenje);
    
     @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Ocene> getOceneUcenikaPoPredmetu(int predmet);
    
    
}
