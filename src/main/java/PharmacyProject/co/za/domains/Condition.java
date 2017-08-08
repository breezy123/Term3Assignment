package PharmacyProject.co.za.domains;

import java.io.Serializable;

/**
 * Created by aubrey on 07/08/2017.
 */
public class Condition implements Serializable{

    private String conditionId;
    private String conditionName;

    public Condition() {
    }

    public String getConditionId() {
        return conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public Condition(Builder build){
        this.conditionId = build.conditionID;
        this.conditionName = build.conditionName;
    }
    public static class Builder{
        private String conditionID;
        private String conditionName;

        public Builder conditionId(String value) {
            this.conditionID = value;
            return this;
        }
        public Builder conditionName(String value) {
            this.conditionName = value;
            return this;
        }
        public Condition build(){
            return new Condition(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Condition)) return false;

        Condition condition = (Condition) o;

        return conditionId.equals(condition.conditionId);
    }

    @Override
    public int hashCode() {
        return conditionId.hashCode();
    }
}
