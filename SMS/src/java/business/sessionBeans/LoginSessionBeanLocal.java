package business.sessionBeans;

import entities.Korisnici;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface LoginSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Korisnici login(final String username, final String password, final int user);
}
