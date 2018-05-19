package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Validated(value = BloodValidator.class)
@Entity
public class Blood {
    private static final int PLASMA_EXPIRATION_DATE = 112;
    private static final int REDCELL_EXPIRATION_DATE = 42;
    private static final int THROMBOCYTE_EXPIRATION_DATE = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final long id = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodType")
    private BloodType bloodType;

    @Size(min = 1, max = 2)
    @Column(name = "group")
    private String group;

    @Column(name = "rh")
    private boolean rh;

    public Blood(BloodType bloodType, String group, boolean rh) {
        this.bloodType = bloodType;
        this.group = group;
        this.rh = rh;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isRh() {
        return rh;
    }

    public void setRh(boolean rh) {
        this.rh = rh;
    }

    public int getExpireDate() {
        switch (this.bloodType) {
            case PLASMA:
                return PLASMA_EXPIRATION_DATE;
            case REDCELL:
                return REDCELL_EXPIRATION_DATE;
            case THROMBOCYTE:
                return THROMBOCYTE_EXPIRATION_DATE;
            case WHOLE:
                return Math.min(Math.min(PLASMA_EXPIRATION_DATE, REDCELL_EXPIRATION_DATE), THROMBOCYTE_EXPIRATION_DATE);
            default:
                return 0;
        }
    }
}
