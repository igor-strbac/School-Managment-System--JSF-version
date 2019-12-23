package business.sessionBeans;

import entities.Roditelji;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface ParentSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Roditelji> getAllParents();
}
