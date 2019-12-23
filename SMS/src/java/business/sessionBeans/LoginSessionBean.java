package business.sessionBeans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entities.Korisnici;

@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Korisnici login(String username, String password, int user) {

        try {
            Query query = em.createNamedQuery("Korisnici.findByNalogLozinkaStatus");
            query.setParameter("nalog", username);
            query.setParameter("lozinka", password);
            query.setParameter("status", user);

            Korisnici result = (Korisnici) query.getSingleResult();

            return result;
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
