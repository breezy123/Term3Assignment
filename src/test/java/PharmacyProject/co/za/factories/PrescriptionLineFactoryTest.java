package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineFactoryTest {
    Map<Integer,Integer>value;

    Prescription prescription;
    Pharmacist pharmacist;
    Patient patient;
    Date today = new Date();
    Medicine medicine;
    Prescriptionline prescription2;
    Prescriptionline prescriptionline1;
    //PrescriptionLineRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

        prescriptionline1 = new Prescriptionline();

        patient = new Patient.Builder()
                .patientId("ABY7382")
                .patientName("Aubrey")
                .medicalaidNumber("DCY8393")
                .medicalaidName("Discovery")
                .build();

        pharmacist = new Pharmacist.Builder()
                .pharmacistID("124TRQF")
                .pharmacistName("TCL-Pharmacy")
                .qualification("PHD Medicine")
                .build();

        prescription = new Prescription.Builder()
                .doctorId("893HGSTS")
                .patientID(patient)
                .pharmacistID(pharmacist)
                .prescriptionDate(today)
                .prescriptionID(73636271)
                .build();

        medicine = new Medicine.Builder()
                .medicineId("PND39837")
                .medicineName("Panado")
                .medicinePrice(139.99)
                .build();

        prescription2 = new Prescriptionline.Builder()
                .lineID(4144)
                .prescriptionID(prescription)
                .instructions("Once a Day")
                .medicineID(medicine)
                .price(139.89)
                .build();

        value = new HashMap<Integer, Integer>();
        value.put(prescriptionline1.getLineId(),4144);

    }

    @Test
    public void testGetPrescriptionLine() throws Exception {
        Prescriptionline prescriptionline = PrescriptionLineFactory.getPrescriptionLine(value,prescription,
                "once a day",medicine,139.99);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

}