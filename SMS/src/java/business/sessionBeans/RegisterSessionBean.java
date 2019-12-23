package business.sessionBeans;

import entities.Administratori;
import entities.Direktori;
import entities.Korisnici;
import entities.Odeljenja;
import entities.Roditelji;
import entities.Ucenici;
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
public class RegisterSessionBean implements RegisterSessionBeanLocal {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean registerKorisnika(String name, String surname, String username, String password, int user) {
        try {
            Query query = em.createNamedQuery("Korisnici.findByNalog");
            query.setParameter("nalog", username);

            Korisnici k = (Korisnici) query.getSingleResult();
                       
            if (k != null) {
                return false;
            }
        } 
        catch (NoResultException nre) {} 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try {
            if(user==0){
                Korisnici noviKorisnik = new Korisnici();
                noviKorisnik.setNalog(username);
                noviKorisnik.setLozinka(password);
                noviKorisnik.setStatus(user);

                em.persist(noviKorisnik);
                
                Administratori noviAdmin = new Administratori();
                noviAdmin.setIme(name);
                noviAdmin.setPrezime(surname);
                noviAdmin.setKorisniciId(noviKorisnik);
                
                em.persist(noviAdmin);

                return true;
            }
            else if(user==1){
                Korisnici noviKorisnik = new Korisnici();
                noviKorisnik.setNalog(username);
                noviKorisnik.setLozinka(password);
                noviKorisnik.setStatus(user);
                
                em.persist(noviKorisnik);
                
                Direktori noviDirektor = new Direktori();
                noviDirektor.setIme(name);
                noviDirektor.setPrezime(surname);
                noviDirektor.setKorisniciId(noviKorisnik);
                noviKorisnik.setStatus(user);
                
                em.persist(noviDirektor);

                return true;
            }
            else if(user==2){
                Korisnici noviKorisnik = new Korisnici();
                noviKorisnik.setNalog(username);
                noviKorisnik.setLozinka(password);
                noviKorisnik.setStatus(user);
                
                em.persist(noviKorisnik);
                
                Ucitelji noviUcitelj = new Ucitelji();
                noviUcitelj.setIme(name);
                noviUcitelj.setPrezime(surname);
                noviUcitelj.setKorisniciId(noviKorisnik);
                        
                em.persist(noviUcitelj);

                return true;  
            }
            else if(user==3){
                Korisnici noviKorisnik = new Korisnici();
                noviKorisnik.setNalog(username);
                noviKorisnik.setLozinka(password);
                noviKorisnik.setStatus(user);
                
                em.persist(noviKorisnik);
                
                Roditelji noviRoditelj = new Roditelji();
                noviRoditelj.setIme(name);
                noviRoditelj.setPrezime(surname);
                noviRoditelj.setKorisniciId(noviKorisnik);
                        
                em.persist(noviRoditelj);

                return true;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean registerUcenika(String ime, String prezime, int odeljenjeID, int roditeljID) {
        try {
            Query q = em.createNamedQuery("Odeljenja.findById");
            q.setParameter("odeljenjaId", odeljenjeID);
            Odeljenja odeljenje = (Odeljenja) q.getSingleResult();
            
            Query q2 = em.createNamedQuery("Roditelji.findById");
            q2.setParameter("roditeljId", roditeljID);
            Roditelji roditelj = (Roditelji) q2.getSingleResult();
            
            Ucenici noviUcenik = new Ucenici(ime, prezime, odeljenje, roditelj);
            em.persist(noviUcenik);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
