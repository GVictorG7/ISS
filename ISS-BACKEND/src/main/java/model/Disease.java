package model;

import org.springframework.validation.annotation.Validated;
import validators.DiseaseValidator;

import javax.persistence.*;
import java.io.Serializable;

@Validated(value = DiseaseValidator.class)
@Entity
@Table(name = "Diseases")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hepatitis")
    private boolean hepatitis;

    @Column(name = "pox")
    private boolean pox;

    @Column(name = "tbc")
    private boolean tbc;

    @Column(name = "mallaria")
    private boolean mallaria;

    @Column(name = "epilepsy")
    private boolean epilepsy;

    @Column(name = "mental_illness")
    private boolean mentalIllness;

    @Column(name = "brucellosis")
    private boolean brucellosis;

    @Column(name = "ulcer")
    private boolean ulcer;

    @Column(name = "diabetes")
    private boolean diabetes;

    @Column(name = "hear_disease")
    private boolean hearDisease;

    @Column(name = "skin_disease")
    private boolean skinDisease;

    @Column(name = "myopia")
    private boolean myopia;

    @Column(name = "cancer")
    private boolean cancer;

    public Disease() {
    }

    public Disease(boolean hepatitis, boolean pox, boolean tbc, boolean mallaria, boolean epilepsy, boolean mentalIllness, boolean brucellosis, boolean ulcer, boolean diabetes, boolean hearDisease, boolean skinDisease, boolean myopia, boolean cancer) {
        this.hepatitis = hepatitis;
        this.pox = pox;
        this.tbc = tbc;
        this.mallaria = mallaria;
        this.epilepsy = epilepsy;
        this.mentalIllness = mentalIllness;
        this.brucellosis = brucellosis;
        this.ulcer = ulcer;
        this.diabetes = diabetes;
        this.hearDisease = hearDisease;
        this.skinDisease = skinDisease;
        this.myopia = myopia;
        this.cancer = cancer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(boolean hepatitis) {
        this.hepatitis = hepatitis;
    }

    public boolean isPox() {
        return pox;
    }

    public void setPox(boolean pox) {
        this.pox = pox;
    }

    public boolean isTbc() {
        return tbc;
    }

    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public boolean isMallaria() {
        return mallaria;
    }

    public void setMallaria(boolean mallaria) {
        this.mallaria = mallaria;
    }

    public boolean isEpilepsy() {
        return epilepsy;
    }

    public void setEpilepsy(boolean epilepsy) {
        this.epilepsy = epilepsy;
    }

    public boolean isMentalIllness() {
        return mentalIllness;
    }

    public void setMentalIllness(boolean mentalIllness) {
        this.mentalIllness = mentalIllness;
    }

    public boolean isBrucellosis() {
        return brucellosis;
    }

    public void setBrucellosis(boolean brucellosis) {
        this.brucellosis = brucellosis;
    }

    public boolean isUlcer() {
        return ulcer;
    }

    public void setUlcer(boolean ulcer) {
        this.ulcer = ulcer;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isHearDisease() {
        return hearDisease;
    }

    public void setHearDisease(boolean hearDisease) {
        this.hearDisease = hearDisease;
    }

    public boolean isSkinDisease() {
        return skinDisease;
    }

    public void setSkinDisease(boolean skinDisease) {
        this.skinDisease = skinDisease;
    }

    public boolean isMyopia() {
        return myopia;
    }

    public void setMyopia(boolean myopia) {
        this.myopia = myopia;
    }

    public boolean isCancer() {
        return cancer;
    }

    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }
}
