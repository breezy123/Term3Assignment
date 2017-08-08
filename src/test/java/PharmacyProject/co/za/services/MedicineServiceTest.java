package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Medicine;
import PharmacyProject.co.za.factories.MedicineFactory;
import PharmacyProject.co.za.services.ImplServi.MedicineServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class MedicineServiceTest {

    MedicineService service;
    //MedicineRepository repository;
    Map<String,String> value;
    @BeforeMethod
    public void setUp() throws Exception {
        service = new MedicineServiceImpl();
        value = new HashMap<String, String>();
        value.put("medicineID","PND738");
        value.put("medicineName","Panado");
    }

    @Test
    public void testCreate() throws Exception {

        Medicine medicine = MedicineFactory.getMedicine(value,245.00);
        service.create(medicine);
        assertEquals("Panado",medicine.getMedicineName());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Medicine readMedicine = service.read("PND738");
        assertEquals(245.00,readMedicine.getMedicinePrice());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Medicine medicine = service.read("PND738");
        Medicine newMedicine = new Medicine.Builder()
                .medicineId("PND738")
                .medicineName("Panado")
                .medicinePrice(245.00)
                .build();

        service.update(newMedicine);
        Medicine updateMedidine = service.read("PND738");
        assertEquals("Panado",updateMedidine.getMedicineName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("PND738");
        Medicine medicine = service.read("PND738");
        assertNull(medicine);
    }

}