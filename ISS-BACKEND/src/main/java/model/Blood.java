package model;

import org.springframework.validation.annotation.Validated;
import validators.BloodValidator;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Validated(value = BloodValidator.class)
@Entity
public class Blood implements Serializable{
=======
import java.io.Serializable;


@Validated(value = BloodValidator.class)
@Entity
public class Blood implements Serializable {
>>>>>>> GradinariuGeorge
    private static final int PLASMA_EXPIRATION_DATE = 112;
    private static final int REDCELL_EXPIRATION_DATE = 42;
    private static final int THROMBOCYTE_EXPIRATION_DATE = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final long id = 1L;

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "rh")
    private boolean rh;

    @Column(name="collectionDate")
    private String collectionDate;

    @Column(name="expireDate")
    private String expireDate;

    public Blood(String bloodType, String group, boolean rh, String collectionDate, String expireDate) {
        this.bloodType = bloodType;
        this.bloodGroup = group;
        this.rh = rh;
        this.collectionDate = collectionDate;
        this.expireDate = expireDate;
    }

    public long getId() {
        return id;
    }


    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGroup() {
        return bloodGroup;
    }

    public void setGroup(String group) {
        this.bloodGroup = group;
    }

    public boolean isRh() {
        return rh;
    }

    public void setRh(boolean rh) {
        this.rh = rh;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public void setExpireDate(String expireDate) {
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
<<<<<<< HEAD
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
=======
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
>>>>>>> GradinariuGeorge
        }
        return c.getTime();
    }


}
