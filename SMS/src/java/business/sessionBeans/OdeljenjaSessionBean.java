package business.sessionBeans;
import entities.Odeljenja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class OdeljenjaSessionBean implements OdeljenjaSessionBeanLocal {
    
    @PersistenceContext(unitName="SMSPU")
    private EntityManager em;
    
    @Override
    public List<Odeljenja> getOdeljenja() {
        try {
            Query q = em.createNamedQuery("Odeljenja.findAll");
            
            List<Odeljenja> odeljenja = q.getResultList();
            return odeljenja;
        }
        catch(NoResultException nre){
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
}
