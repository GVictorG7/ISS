package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Validated(value = BloodValidator.class)
@Entity
public class Blood implements Serializable{
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

    @Column(name="collectionDate")
    private Date collectionDate;

    @Column(name="expireDate")
    private Date expireDate;

    public Blood(BloodType bloodType, String group, boolean rh, Date collectionDate, Date expireDate) {
        this.bloodType = bloodType;
        this.group = group;
        this.rh = rh;
        this.collectionDate = collectionDate;
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

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try{
            //Setting the date to the given date
            c.setTime(sdf.parse(String.valueOf(collectionDate)));
        }catch(ParseException e){
            e.printStackTrace();
        }

        switch (this.bloodType) {
            case PLASMA:
                c.add(Calendar.DAY_OF_MONTH,  PLASMA_EXPIRATION_DATE);
                break;
            case REDCELL:
                c.add(Calendar.DAY_OF_MONTH,  REDCELL_EXPIRATION_DATE);
                break;
            case THROMBOCYTE:
                c.add(Calendar.DAY_OF_MONTH,  THROMBOCYTE_EXPIRATION_DATE);
                break;
            case WHOLE:
                c.add(Calendar.DAY_OF_MONTH, Math.min(Math.min(PLASMA_EXPIRATION_DATE, REDCELL_EXPIRATION_DATE), THROMBOCYTE_EXPIRATION_DATE) );
        }
        return c.getTime();
    }


}
