package business.sessionBeans;
import entities.Predmeti;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PredmetiSessionBean implements PredmetiSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;
    @Override
    public List<Predmeti> getAllPredmeti() {
        try {
            Query q = em.createNamedQuery("Predmeti.findAll");
        
            List<Predmeti> predmeti = q.getResultList();
        
            return predmeti;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean dodajPredmet(String naziv) {
        try {
            Query q = em.createNamedQuery("Predmeti.findByIme");        
            q.setParameter("ime", naziv);
            
            List<Predmeti> predmeti = (List<Predmeti>) q.getResultList();
            
                if(predmeti.size()==0) {
                    Predmeti predmet = new Predmeti();
                    predmet.setIme(naziv);
                    em.persist(predmet);
                
                    return true;
                }
                return false;
        }     
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean brisiPredmet(int pr) {
        try {
            Query q = em.createNamedQuery("Predmeti.findById");
            q.setParameter("id", pr);
            
            Predmeti p = (Predmeti) q.getSingleResult();
            
            em.remove(p);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
