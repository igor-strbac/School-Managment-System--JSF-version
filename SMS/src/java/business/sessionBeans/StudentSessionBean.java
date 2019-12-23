package business.sessionBeans;

import entities.Odeljenja;
import entities.Ucenici;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentSessionBean implements StudentSessionBeanLocal {
    
    @PersistenceContext(unitName="SMSPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<Ucenici> getAllStudents() {
        
        try {
        Query query = em.createNamedQuery("Ucenici.findAll");
        List <Ucenici> ucenici = (List<Ucenici>) query.getResultList();
        return ucenici;
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
        public List<Ucenici> getStudentsFromDepartment(Integer odeljenje) {
        
        try {
        Query findOdeljenje = em.createNamedQuery("Odeljenja.findById");
        findOdeljenje.setParameter("id", odeljenje);
        Odeljenja razred = (Odeljenja) findOdeljenje.getSingleResult();
        Query query = em.createNamedQuery("Ucenici.findUceniciByOdeljenje");
        query.setParameter("odeljenja", razred);
        List <Ucenici> ucenici = (List<Ucenici>) query.getResultList();
        return ucenici;
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
    public Ucenici getStudentWhereId(int uceniciId) {
        Query query = em.createNamedQuery("Ucenici.findById");
        query.setParameter("uceniciId", uceniciId);
        Ucenici ucenici = (Ucenici) query.getSingleResult();
        return ucenici;
    }
        
}
