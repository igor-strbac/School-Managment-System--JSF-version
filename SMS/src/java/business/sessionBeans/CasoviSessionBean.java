package business.sessionBeans;

import entities.Casovi;
import entities.Dani;
import entities.Odeljenja;
import entities.Predmeti;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CasoviSessionBean implements CasoviSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;
    
    @Override
    public List<Casovi> getAllCasovi() {
        try {
            Query q = em.createNamedQuery("Casovi.findAll");
            List<Casovi> casovi = q.getResultList();
         
            return casovi;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void dodajRaspored(int broj, int Predmet, int Dan, int Odeljenje) {
        try {
            Query q = em.createNamedQuery("Predmeti.findById");
            q.setParameter("id", Predmet);
            Predmeti predmet = (Predmeti) q.getSingleResult();
            
            Query q2 = em.createNamedQuery("Dani.findById");
            q2.setParameter("id", Dan);
            Dani dan = (Dani) q2.getSingleResult();
            
            Query q3 = em.createNamedQuery("Odeljenja.findById");
            q3.setParameter("odeljenjaId", Odeljenje);
            Odeljenja odeljenje = (Odeljenja) q3.getSingleResult();
            
            Casovi casovi = new Casovi();
            casovi.setBroj(broj);
            casovi.setDaniId(dan);
            casovi.setOdeljenjaId(odeljenje);
            casovi.setPredmetiId(predmet);
            em.persist(casovi);
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void brisiRaspored(int odeljenje) {
        try {
            Query q = em.createNamedQuery("Odeljenja.findById");
            q.setParameter("odeljenjaId", odeljenje);
            
            Odeljenja odeljenjee = (Odeljenja) q.getSingleResult();
            
            Query q2 = em.createNamedQuery("Casovi.findByOdeljenje");
            q2.setParameter("odeljenje", odeljenjee);
            
            List<Casovi> casovi = (List<Casovi>) q2.getResultList();
            
            for(Casovi c:casovi){
                em.remove(c);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
