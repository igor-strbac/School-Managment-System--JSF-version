package business.sessionBeans;

import entities.Ucenici;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface StudentSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Ucenici> getAllStudents();
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Ucenici> getStudentsFromDepartment(Integer odeljenje);
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Ucenici getStudentWhereId(int uceniciId);
}
