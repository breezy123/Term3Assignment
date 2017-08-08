package PharmacyProject.co.za.domains;

import java.io.Serializable;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class Prescription implements Serializable {

    private int prescriptionID;
    private Date prescriptionDate;
    private String doctorId;
    private Patient patientID;
    private Pharmacist pharmacistID;

    public Prescription() {
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public Pharmacist getPharmacistID() {
        return pharmacistID;
    }

    public Prescription(Builder build){
        this.prescriptionID = build.prescriptionID;
        this.prescriptionDate =build.prescriptionDate;
        this.doctorId = build.doctorId;
        this.patientID = build.patientID;
        this.pharmacistID =build.pharmacistID;
    }
    public static class Builder{
        private int prescriptionID;
        private Date prescriptionDate;
        private String doctorId;
        private Patient patientID;
        private Pharmacist pharmacistID;

        public Builder prescriptionID(int value){
            this.prescriptionID = value;
            return this;
        }
        public Builder prescriptionDate(Date value){
            this.prescriptionDate = value;
            return this;
        }
        public Builder doctorId(String value){
            this.doctorId = value;
            return this;
        }
        public Builder patientID(Patient value){
            this.patientID = value;
            return this;
        }
        public Builder pharmacistID(Pharmacist value){
            this.pharmacistID = value;
            return this;
        }
        public Prescription build(){
            return new Prescription(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescription)) return false;

        Prescription that = (Prescription) o;

        return getPrescriptionID() == that.getPrescriptionID();
    }

    @Override
    public int hashCode() {
        return getPrescriptionID();
    }
}
