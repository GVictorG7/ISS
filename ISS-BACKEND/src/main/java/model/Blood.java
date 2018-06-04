package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Validated(value = BloodValidator.class)
@Entity
@Table(name = "Blood")
public class Blood implements Serializable {

    private static final int PLASMA_EXPIRATION_DATE = 112;
    private static final int REDCELL_EXPIRATION_DATE = 42;
    private static final int THROMBOCYTE_EXPIRATION_DATE = 5;
    private static final int WHOLE_EXPIRATION_DATE = 21;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final long id = 1L;

    @Column(name = "blood_type")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "bloodRh")
    @Enumerated(EnumType.STRING)
    private BloodRH bloodRh;

    @Column(name = "blood_category")
    @Enumerated(EnumType.STRING)
    private BloodCategory bloodCategory;

    @Column(name = "used")
    private Boolean used;
    @Column(name = "expire_date")
    private LocalDate expireDate;

    public Blood() {
    }

    public Blood(BloodType bloodType, BloodRH bloodRH, Boolean used, LocalDate expireDate) {
        this.bloodType = bloodType;
        this.bloodRh = bloodRH;
        this.bloodCategory = BloodCategory.WHOLE;
        this.used = used;
        this.expireDate = expireDate;
    }

    public Blood(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, Boolean used, LocalDate expireDate) {
        this.bloodType = bloodType;
        this.bloodRh = bloodRH;
        this.bloodCategory = bloodCategory;
        this.used = used;
        this.expireDate = expireDate;
    }

    public long getId() {
        return id;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodRH getBloodRH() {
        return bloodRh;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.bloodRh = bloodRH;
    }

    public BloodCategory getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(BloodCategory bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public static int getDaysToExpire(BloodCategory bloodCategory) throws RuntimeException {
        switch (bloodCategory) {
            case PLASMA:
                return PLASMA_EXPIRATION_DATE;
            case REDCELL:
                return REDCELL_EXPIRATION_DATE;
            case THROMBOCYTE:
                return THROMBOCYTE_EXPIRATION_DATE;
            case WHOLE:
                return WHOLE_EXPIRATION_DATE;
        }
        throw new RuntimeException("Invalid BloodCategory");
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
