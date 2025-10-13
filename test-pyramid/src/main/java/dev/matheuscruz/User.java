package dev.matheuscruz;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Column(name = "username", unique = true, nullable = false)
    String username;
    @Column(name = "password", nullable = false)
    String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = Objects.requireNonNull(username, "'username' must not be null");
        this.password = Objects.requireNonNull(password, "'password' must not be null");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
