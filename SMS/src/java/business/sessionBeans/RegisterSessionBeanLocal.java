package business.sessionBeans;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface RegisterSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean registerKorisnika(String name, String surname, String username, String password, int user);
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean registerUcenika(String ime, String prezime, int odeljenjeID, int roditeljID);
}
