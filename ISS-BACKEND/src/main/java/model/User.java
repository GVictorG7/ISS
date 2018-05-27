package model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @Column(name = "username")
    private String id;

    @NotEmpty
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.id = username;
        this.password = password;
    }

    public String getUsername() {
        return id;
    }

    public void setUsername(String username) {
        this.id = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}