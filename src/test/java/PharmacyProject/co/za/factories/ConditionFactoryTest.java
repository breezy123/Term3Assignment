package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class ConditionFactoryTest {

    Map<String,String>value;

    @BeforeMethod
    public void setUp() throws Exception{
        value = new HashMap<String, String>();
        value.put("conditionId","4144");
        value.put("conditionName","Birdflue");
    }
    @Test
    public void testGetCondition() throws Exception {
        Condition condition = ConditionFactory.getCondition(value);
        assertEquals("4144",condition.getConditionId());
    }

}