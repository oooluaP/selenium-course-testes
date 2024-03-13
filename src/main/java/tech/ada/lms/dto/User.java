package tech.ada.lms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 2, message = "First name must be at least 3 characters long")
    private String firstName;
    @Size(min = 2, message = "Last name must be at least 3 characters long")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 2, message = "Username must be at least 3 characters long")
    private String username;
    @Size(min = 8, message = "Password must be at least 6 characters long")
    @NotBlank
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
