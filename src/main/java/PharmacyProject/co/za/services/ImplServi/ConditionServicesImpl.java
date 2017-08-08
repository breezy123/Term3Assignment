package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.repositories.ConditionRepository;
import PharmacyProject.co.za.repositories.Imple.ConditionRepositoryImpl;
import PharmacyProject.co.za.services.ConditionServices;

/**
 * Created by aubrey on 08/08/2017.
 */
public class ConditionServicesImpl implements ConditionServices {

    static ConditionRepository repository = ConditionRepositoryImpl.getInstance();

    public static ConditionRepositoryImpl getInstance(){
        if(repository==null){
            repository = new ConditionRepositoryImpl();
        }
        return (ConditionRepositoryImpl) repository;
    }

    public Condition create(Condition condition) {
        return repository.create(condition);
    }

    public Condition read(String conditionId) {
       return repository.read(conditionId);
    }

    public Condition update(Condition condition) {
        return repository.update(condition);
    }

    public void delete(String conditionId) {
         repository.delete(conditionId);
    }
}
