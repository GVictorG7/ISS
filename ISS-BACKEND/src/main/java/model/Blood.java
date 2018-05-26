package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private long id;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "blood_rh")
    private String bloodRh;

    @Column(name = "blood_category")
    private String bloodCategory;

    @Column(name = "harvest_date")
    private Date harvestDate;

    @Column(name = "expire_date")
    private Date expireDate;

    public Blood() {
    }

    public Blood(String bloodType, String bloodRh, String bloodCategory, Date harvestDate, Date expireDate) {
        this.bloodType = bloodType;
        this.bloodRh = bloodRh;
        this.bloodCategory = bloodCategory;
        this.harvestDate = harvestDate;
        this.expireDate = expireDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodRh() {
        return bloodRh;
    }

    public void setBloodRh(String bloodRh) {
        this.bloodRh = bloodRh;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }

    public int getExpireDate() {
        switch (this.bloodType) {
            case "PLASMA":
                return PLASMA_EXPIRATION_DATE;
            case "REDCELL":
                return REDCELL_EXPIRATION_DATE;
            case "THROMBOCYTE":
                return THROMBOCYTE_EXPIRATION_DATE;
            case "WHOLE":
                return Math.min(Math.min(PLASMA_EXPIRATION_DATE, REDCELL_EXPIRATION_DATE), THROMBOCYTE_EXPIRATION_DATE);
            default:
                return 0;
        }
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
