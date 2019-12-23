package business.sessionBeans;

import entities.Korisnici;
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
public class UciteljiSessionBean implements UciteljiSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Ucitelji getUciteljByKorisniciId(Integer korisniciId) {
        Query findKorisnici = em.createNamedQuery("Korisnici.findById");
        findKorisnici.setParameter("id", korisniciId);
        Korisnici korisnici = (Korisnici) findKorisnici.getSingleResult();
        Query query = em.createNamedQuery("Ucitelji.findByKorisniciId");
        query.setParameter("id", korisnici);
        Ucitelji ucitelji = (Ucitelji) query.getSingleResult();
        return ucitelji;       
    }
    
    @Override
    public List<Ucitelji> getAllUcitelji() {
        try {
            Query q = em.createNamedQuery("Ucitelji.findAll");
            
            List<Ucitelji> ucitelji = (List<Ucitelji>) q.getResultList();
            
            return ucitelji;
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
