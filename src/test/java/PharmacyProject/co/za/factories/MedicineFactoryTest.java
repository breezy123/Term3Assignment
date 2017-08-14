package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Medicine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class MedicineFactoryTest {
    Map<String,String>value;
    @BeforeMethod
    public void setUp() throws Exception {
        //Medicine medicine = new Medicine();
        value = new HashMap<String, String>();
        value.put("medicineID","PND738");
        value.put("medicineName","Panado");
    }

    @Test
    public void testGetMedicine() throws Exception {
        Medicine medicineOoject =  MedicineFactory.getMedicine(value,56.98);
        assertEquals(56.98,medicineOoject.getMedicinePrice());
    }

}