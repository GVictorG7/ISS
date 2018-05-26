package controllers.formatters;

public class HospitalFields {
    private long id;

    private String name;

    private String adress;

    public HospitalFields() {}
    public HospitalFields(long id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
