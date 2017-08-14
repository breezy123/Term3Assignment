package PharmacyProject.co.za.domains;

import java.io.Serializable;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientCondition implements Serializable {

    private Patient patientId;
    private Condition conditionId;
    private Date dateDiagnosed;

    public PatientCondition() {
    }

    public Patient getPatientId() {
        return patientId;
    }

    public Condition getConditionId() {
        return conditionId;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public PatientCondition(Builder build){

        this.patientId = build.patientId;
        this.conditionId = build.conditionId;
        this.dateDiagnosed = build.dateDiagnosed;
    }

    public static class Builder{

        private Patient patientId;
        private Condition conditionId;
        private Date dateDiagnosed;

        public Builder patientIdentity(Patient value){
            this.patientId = value;
            return this;
        }
        public Builder conditionIdentity(Condition value){
            this.conditionId = value;
            return this;
        }
        public Builder dateDiagnosed(Date value){
            this.dateDiagnosed = value;
            return this;
        }
        public PatientCondition build(){
            return new PatientCondition(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientCondition)) return false;

        PatientCondition that = (PatientCondition) o;

        return getPatientId().equals(that.getPatientId());
    }

    @Override
    public int hashCode() {
        return getPatientId().hashCode();
    }
}
