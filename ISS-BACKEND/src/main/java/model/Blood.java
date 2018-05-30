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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final long id = 1L;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private BloodType type;

    @Column(name = "RH")
    @Enumerated(EnumType.STRING)
    private BloodRH RH;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private BloodCategory category;

    @Column(name = "used")
    private Boolean used;

    public Blood() {
    }

    public Blood(BloodType bloodType, BloodRH bloodRH, Boolean used) {
        this.type = bloodType;
        this.RH = bloodRH;
        this.category = BloodCategory.WHOLE;
        this.used = used;
    }

    public Blood(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, Boolean used) {
        this.type = bloodType;
        this.RH = bloodRH;
        this.category = bloodCategory;
        this.used = used;
    }

    public long getId() {
        return id;
    }

    public BloodType getBloodType() {
        return type;
    }

    public void setBloodType(BloodType bloodType) {
        this.type = bloodType;
    }

    public BloodRH getBloodRH() {
        return RH;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.RH = bloodRH;
    }

    public BloodCategory getBloodCategory() {
        return category;
    }

    public void setBloodCategory(BloodCategory bloodCategory) {
        this.category = bloodCategory;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public int getDaysToExpire() throws RuntimeException {
        switch (this.category){
            case PLASMA:return PLASMA_EXPIRATION_DATE;
            case REDCELL:return REDCELL_EXPIRATION_DATE;
            case THROMBOCYTE:return THROMBOCYTE_EXPIRATION_DATE;
            case WHOLE:return Math.min(Math.min(PLASMA_EXPIRATION_DATE,REDCELL_EXPIRATION_DATE),THROMBOCYTE_EXPIRATION_DATE);
        }
        throw new RuntimeException("Invalid BloodCategory");
    }
}
