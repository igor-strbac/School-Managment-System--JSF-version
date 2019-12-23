package business.sessionBeans;

import entities.Roditelji;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ParentSessionBean implements ParentSessionBeanLocal {
    @PersistenceContext(unitName="SMSPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<Roditelji> getAllParents() {
        
        Query query = em.createNamedQuery("Roditelji.findAll");
        List<Roditelji> roditelji = (List<Roditelji>) query.getResultList();
        return roditelji;
    }
    
}
