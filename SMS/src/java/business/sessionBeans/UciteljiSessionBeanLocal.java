package business.sessionBeans;

import entities.Ucitelji;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface UciteljiSessionBeanLocal {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Ucitelji getUciteljByKorisniciId(Integer korisniciId);
    
    public List<Ucitelji> getAllUcitelji();
}
