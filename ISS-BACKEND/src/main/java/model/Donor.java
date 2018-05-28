package model;

import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Donors")
public class Donor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id=1L;

    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @NotNull
    @NotEmpty
    @Column(name = "domiciliu")
    private String domiciliu;

    @Nullable
    @Column(name = "resedinta")
    private String resedinta;

    @Nullable
    @Column(name = "email")
    private String email;

    @Nullable
    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    public Donor() {
    }

    public Donor(String name, LocalDate birthday, String domiciliu, String email, String phone, User user) {
        this.name = name;
        this.birthday = birthday;
        this.domiciliu = domiciliu;
        this.email = email;
        this.phone = phone;
        this.user = user;
    }

    public Donor(String name, LocalDate birthday, String domiciliu, String resedinta, String email, String phone, User user) {
        this.name = name;
        this.birthday = birthday;
        this.domiciliu = domiciliu;
        this.resedinta = resedinta;
        this.email = email;
        this.phone = phone;
        this.user = user;
    }
}
