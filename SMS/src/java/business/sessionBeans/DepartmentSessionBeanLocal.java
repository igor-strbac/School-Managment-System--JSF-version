package business.sessionBeans;
import entities.Odeljenja;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
@Local
public interface DepartmentSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Odeljenja> getAllDepartments();
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Odeljenja getDepartmentWhereUciteljiId(Integer id);
}
