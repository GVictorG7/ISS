package model;

import org.springframework.validation.annotation.Validated;
import validators.DiseaseReportValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated(value = DiseaseReportValidator.class)
@Entity
public class DiseaseReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "hepatitis")
    private boolean hepatitis;

    @NotNull
    @Column(name = "tbc")
    private boolean tbc;

    @NotNull
    @Column(name = "pox")
    private boolean pox;

    @NotNull
    @Column(name = "malaria")
    private boolean malaria;

    @NotNull
    @Column(name = "epilepsy")
    private boolean epilepsy;

    @NotNull
    @Column(name = "mentalIllness")
    private boolean mentalIllness;

    @NotNull
    @Column(name = "brucellosis")
    private boolean brucellosis;

    @NotNull
    @Column(name = "ulcer")
    private boolean ulcer;

    @NotNull
    @Column(name = "diabetes")
    private boolean diabetes;

    @NotNull
    @Column(name = "heartDisease")
    private boolean heartDisease;

    @NotNull
    @Column(name = "skinDisease")
    private boolean skinDisease;

    @NotNull
    @Column(name = "myopia")
    private boolean myopia;

    @NotNull
    @Column(name = "cancer")
    private boolean cancer;

    public DiseaseReport() {
    }

    public DiseaseReport(int id, boolean hepatitis, boolean tbc, boolean pox, boolean malaria, boolean epilepsy, boolean mentalIllness, boolean brucellosis, boolean ulcer, boolean diabetes, boolean heartDisease, boolean skinDisease, boolean myopia, boolean cancer) {
        this.id = id;
        this.hepatitis = hepatitis;
        this.tbc = tbc;
        this.pox = pox;
        this.malaria = malaria;
        this.epilepsy = epilepsy;
        this.mentalIllness = mentalIllness;
        this.brucellosis = brucellosis;
        this.ulcer = ulcer;
        this.diabetes = diabetes;
        this.heartDisease = heartDisease;
        this.skinDisease = skinDisease;
        this.myopia = myopia;
        this.cancer = cancer;
    }

    public int getId() {
        return id;
    }

    public boolean isHepatitis() {
        return hepatitis;
    }

    public boolean isTbc() {
        return tbc;
    }

    public boolean isPox() {
        return pox;
    }

    public boolean isMalaria() {
        return malaria;
    }

    public boolean isEpilepsy() {
        return epilepsy;
    }

    public boolean isMentalIllness() {
        return mentalIllness;
    }

    public boolean isBrucellosis() {
        return brucellosis;
    }

    public boolean isUlcer() {
        return ulcer;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public boolean isSkinDisease() {
        return skinDisease;
    }

    public boolean isMyopia() {
        return myopia;
    }

    public boolean isCancer() {
        return cancer;
    }
}
