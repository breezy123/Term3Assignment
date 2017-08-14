package PharmacyProject.co.za.domains;

import java.io.Serializable;

/**
 * Created by aubrey on 07/08/2017.
 */
public class Patient implements Serializable {

    private String patientID;
    private String patientName;
    private String medicalaidName;
    private String medicalaidNumber;
    //public String getPatientID;

    public Patient() {
    }


    public String getPatientName() {
        return patientName;
    }

    public String getMedicalaidName() {
        return medicalaidName;
    }

    public String getMedicalaidNumber() {
        return medicalaidNumber;
    }

    public String getPatientID() {
        return patientID;
    }

    public Patient(Builder build){

        this.patientID = build.patientID;
        this.patientName = build.patientName;
        this.medicalaidName = build.medicalaidName;
        this.medicalaidNumber = build.medicalaidNumber;
    }
    public static class Builder{

        private String patientID;
        private String patientName;
        private String medicalaidName;
        private String medicalaidNumber;

        public Builder patientId(String value){
            this.patientID = value;
            return this;
        }
        public Builder patientName(String value){
            this.patientName = value;
            return this;
        }
        public Builder medicalaidName(String value){
            this.medicalaidName = value;
            return this;
        }
        public Builder medicalaidNumber(String value){
            this.medicalaidNumber = value;
            return this;
        }
        public Patient build(){
            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        return getPatientID().equals(patient.getPatientID());
    }

    @Override
    public int hashCode() {
        return getPatientID().hashCode();
    }
}
