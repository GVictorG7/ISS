package controllers.formatters;

public class    ModifiedRequestFields {
    private Long id;

    public ModifiedRequestFields() {
    }

    public ModifiedRequestFields(Long id, String newStatus) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
