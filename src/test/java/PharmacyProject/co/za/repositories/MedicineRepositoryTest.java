package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Medicine;
import PharmacyProject.co.za.factories.MedicineFactory;
import PharmacyProject.co.za.repositories.Imple.MedicineRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by aubrey on 07/08/2017.
 */

public class MedicineRepositoryTest {
    Map<String,String>value;
    MedicineRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

        repository = MedicineRepositoryImpl.getInstance();
        value = new HashMap<String, String>();
        value.put("medicineID","PND738");
        value.put("medicineName","Panado");
    }

    @Test
    public void testCreate() throws Exception {
        Medicine medicine = MedicineFactory.getMedicine(value,245.00);
        repository.create(medicine);
        assertEquals("Panado",medicine.getMedicineName());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Medicine readMedicine = repository.read("PND738");
        assertEquals(245.00,readMedicine.getMedicinePrice());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Medicine medicine = repository.read("PND738");
        Medicine newMedicine = new Medicine.Builder()
                .medicineId("PND738")
                .medicineName("Panado")
                .medicinePrice(245.00)
                .build();

        repository.update(newMedicine);
        Medicine updateMedidine = repository.read("PND738");
        assertEquals("Panado",updateMedidine.getMedicineName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("PND738");
        Medicine medicine = repository.read("PND738");
        assertNull(medicine);
    }

}