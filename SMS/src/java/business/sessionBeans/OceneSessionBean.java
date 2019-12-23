package business.sessionBeans;

import entities.Ocene;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OceneSessionBean implements OceneSessionBeanLocal {

    @PersistenceContext(unitName="SMSPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<Ocene> getOceneUcenika(Integer ucenik) {
        Query query = em.createNamedQuery("Ocene.findByPredmet");
        return null;
    }

    @Override
    public List<Ocene> getOceneUcenikaPoPredmetuOdeljenju(int predmet, int odeljenje) {
        try {
        Query query = em.createNamedQuery("Ocene.findByOdeljenjePredmet");
        query.setParameter("predmetiId", predmet);
        query.setParameter("odeljenjaId", odeljenje);
        
        List<Ocene> ocene = (List<Ocene>) query.getResultList();
        
        return ocene;
        }
        catch (NoResultException nre) {
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Ocene> getOceneUcenikaPoPredmetu(int predmet) {
        try {
        Query query = em.createNamedQuery("Ocene.findByPredmet");
        query.setParameter("predmetiId", predmet);
        
        List<Ocene> ocene = (List<Ocene>) query.getResultList();
        
        return ocene;
        }
        catch (NoResultException nre) {
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    

    
}
