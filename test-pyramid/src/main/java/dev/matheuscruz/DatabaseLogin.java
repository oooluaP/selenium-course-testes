package dev.matheuscruz;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseLogin {

    public boolean authenticate(String username, String password) {
        User user = User.find("username", username).firstResult();
        return user != null && user.password.equals(password);
    }

}
