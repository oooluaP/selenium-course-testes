package dev.matheuscruz;

import java.util.Map;

public class InMemoryLogin {

    private static final Map<String, String> USERS = Map.of(
            "bob", "bob",
            "alice", "alice");

    public boolean authenticate(String username, String password) {
        return USERS.containsKey(username) && USERS.get(username).equals(password);
    }

}
