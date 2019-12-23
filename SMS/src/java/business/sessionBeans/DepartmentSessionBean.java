package business.sessionBeans;

import entities.Odeljenja;
import entities.Ucitelji;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class DepartmentSessionBean implements DepartmentSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<Odeljenja> getAllDepartments() {
        try {
        Query query = em.createNamedQuery("Odeljenja.findAll");
        List<Odeljenja> odeljenja = (List<Odeljenja>)query.getResultList();
        return  odeljenja;
        }
        catch (NoResultException nre) {
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Odeljenja getDepartmentWhereUciteljiId(Integer id){
        Query findUcitelj = em.createNamedQuery("Ucitelji.findById");
        findUcitelj.setParameter("id", id);
        Ucitelji ucitelji = (Ucitelji) findUcitelj.getSingleResult();
        Query query = em.createNamedQuery("Odeljenja.findByUciteljiId");
        query.setParameter("id", ucitelji);
        Odeljenja odeljenja = (Odeljenja) query.getSingleResult();
        return odeljenja;    
    }
}
