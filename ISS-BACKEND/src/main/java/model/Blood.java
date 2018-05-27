package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;

import java.io.Serializable;

@Validated(value = BloodValidator.class)
@Entity
@Table(name = "Blood")
public class Blood implements Serializable {

    private static final int PLASMA_EXPIRATION_DATE = 112;
    private static final int REDCELL_EXPIRATION_DATE = 42;
    private static final int THROMBOCYTE_EXPIRATION_DATE = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final long id = 1L;

    @Column(name = "bloodType")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "bloodRH")
    @Enumerated(EnumType.STRING)
    private BloodRH bloodRH;

    @Column(name = "bloodCategory")
    @Enumerated(EnumType.STRING)
    private BloodCategory bloodCategory;

    public Blood() {
    }

    public Blood(BloodType bloodType, BloodRH bloodRH) {
        this.bloodType = bloodType;
        this.bloodRH = bloodRH;
        this.bloodCategory = BloodCategory.WHOLE;
    }

    public Blood(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory) {
        this.bloodType = bloodType;
        this.bloodRH = bloodRH;
        this.bloodCategory = bloodCategory;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodRH getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.bloodRH = bloodRH;
    }

    public BloodCategory getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(BloodCategory bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public int getDaysToExpire() throws RuntimeException {
        switch (this.bloodCategory){
            case PLASMA:return PLASMA_EXPIRATION_DATE;
            case REDCELL:return REDCELL_EXPIRATION_DATE;
            case THROMBOCYTE:return THROMBOCYTE_EXPIRATION_DATE;
            case WHOLE:return Math.min(Math.min(PLASMA_EXPIRATION_DATE,REDCELL_EXPIRATION_DATE),THROMBOCYTE_EXPIRATION_DATE);
        }
        throw new RuntimeException("Invalid BloodCategory");
    }
}
