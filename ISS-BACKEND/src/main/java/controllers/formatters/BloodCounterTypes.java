package controllers.formatters;

import java.io.Serializable;

public class BloodCounterTypes implements Serializable {
    private BloodCounterType typeO;
    private BloodCounterType typeA;
    private BloodCounterType typeB;
    private BloodCounterType typeAB;

    public BloodCounterTypes() {
        setTypeO(new BloodCounterType());
        setTypeA(new BloodCounterType());
        setTypeB(new BloodCounterType());
        setTypeAB(new BloodCounterType());
    }

    public BloodCounterTypes(BloodCounterType typeO, BloodCounterType typeA, BloodCounterType typeB, BloodCounterType typeAB) {
        this.typeO = typeO;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeAB = typeAB;
    }

    public BloodCounterType getTypeO() {
        return typeO;
    }

    public void setTypeO(BloodCounterType typeO) {
        this.typeO = typeO;
    }

    public BloodCounterType getTypeA() {
        return typeA;
    }

    public void setTypeA(BloodCounterType typeA) {
        this.typeA = typeA;
    }

    public BloodCounterType getTypeB() {
        return typeB;
    }

    public void setTypeB(BloodCounterType typeB) {
        this.typeB = typeB;
    }

    public BloodCounterType getTypeAB() {
        return typeAB;
    }

    public void setTypeAB(BloodCounterType typeAB) {
        this.typeAB = typeAB;
    }
}
