package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Pharmacist;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PharmacistFactoryTest {
    Map<String,String>value;
    @BeforeMethod
    public void setUp() throws Exception {
        value = new HashMap<String, String>();
        value.put("pharmacistID","MTL7263");
        value.put("pharmacistName","MitchellsPlain Medi-Chemist");
        value.put("qualification","PHD In Medicine");
    }

    @Test
    public void testGetPharmacist() throws Exception {
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(value);
        assertEquals("MTL7263",pharmacist.getPharmacistID());
    }

}