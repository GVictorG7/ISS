package model;

import org.springframework.validation.annotation.Validated;
import validators.TreatmentValidator;

import javax.persistence.*;
import java.io.Serializable;

@Validated(value = TreatmentValidator.class)
@Entity
@Table(name = "Treatments")
public class Treatment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hypertension")
    private boolean hypertension;

    @Column(name = "heart_disease")
    private boolean heartDisease;

    @Column(name = "kidney_disease")
    private boolean kidneyDisease;

    @Column(name = "mental_illness")
    private boolean mentalIllness;

    @Column(name = "blood_disease")
    private boolean bloodDisease;

    @Column(name = "endocrine_affection")
    private boolean endocrineAffection;

    public Treatment() {
    }

    public Treatment(boolean hypertension, boolean heartDisease, boolean kidneyDisease, boolean mentalIllness, boolean bloodDisease, boolean endocrineAffection) {
        this.hypertension = hypertension;
        this.heartDisease = heartDisease;
        this.kidneyDisease = kidneyDisease;
        this.mentalIllness = mentalIllness;
        this.bloodDisease = bloodDisease;
        this.endocrineAffection = endocrineAffection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isHypertension() {
        return hypertension;
    }

    public void setHypertension(boolean hypertension) {
        this.hypertension = hypertension;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    public boolean isKidneyDisease() {
        return kidneyDisease;
    }

    public void setKidneyDisease(boolean kidneyDisease) {
        this.kidneyDisease = kidneyDisease;
    }

    public boolean isMentalIllness() {
        return mentalIllness;
    }

    public void setMentalIllness(boolean mentalIllness) {
        this.mentalIllness = mentalIllness;
    }

    public boolean isBloodDisease() {
        return bloodDisease;
    }

    public void setBloodDisease(boolean bloodDisease) {
        this.bloodDisease = bloodDisease;
    }

    public boolean isEndocrineAffection() {
        return endocrineAffection;
    }

    public void setEndocrineAffection(boolean endocrineAffection) {
        this.endocrineAffection = endocrineAffection;
    }
}
