package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.repositories.ConditionRepository;
import PharmacyProject.co.za.domains.Condition;
import java.util.*;

/**
 * Created by aubrey on 07/08/2017.
 */
public class ConditionRepositoryImpl implements ConditionRepository {

    private static ConditionRepositoryImpl repository=null;

    private Map<String,Condition> conditionTable;

    public ConditionRepositoryImpl(){
        conditionTable = new HashMap<String, Condition>();
    }
    public static ConditionRepositoryImpl getInstance(){
        if(repository==null){
            repository = new ConditionRepositoryImpl();
        }
        return  repository;
    }

    public Condition create(Condition condition) {
        conditionTable.put(condition.getConditionId(),condition);
        Condition savedCondition = conditionTable.get(condition.getConditionId());
        return savedCondition;
    }

    public Condition read(String conditionId) {
       Condition condition = conditionTable.get(conditionId);
       return condition;
    }

    public Condition update(Condition condition) {
        conditionTable.put(condition.getConditionId(),condition);
        Condition savedCondition = conditionTable.get(condition.getConditionId());
        return savedCondition;
    }

    public void delete(String conditionId) {
        conditionTable.remove(conditionId);
    }
}
