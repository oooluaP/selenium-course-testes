package tech.ada.lms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class DeveloperController {


    private static final List<Developer> DEVELOPERS_LIST = new ArrayList<>();

    @GetMapping("/create-developer")
    public String createDeveloper() {
        return "create-developer";
    }


    @GetMapping("/list-developers")
    public String listDevelopers(Model model) {
        model.addAttribute("developers", DEVELOPERS_LIST);
        System.out.println(DEVELOPERS_LIST);
        return "list-developers";
    }

    @PostMapping("/create-developer")
    public String createNewDeveloper(@ModelAttribute("developer") Developer developer) {
        DEVELOPERS_LIST.add(developer);
        return "redirect:/list-developers";
    }

    @GetMapping("/delete-developer/{username}")
    public String deleteDeveloper(@PathVariable("username") String username) {
        DEVELOPERS_LIST.removeIf(dev -> dev.username.equals(username));
        return "list-developers";
    }

    public static final class Developer {
        private final String username;
        private final String email;
        private final String password;
        private final String bio;
        private final List<String> careers;
        private final String preferredLanguage;
        private final String tShirt;

        public Developer(
                String username,
                String email,
                String password,
                String bio,
                List<String> careers,
                String preferredLanguage,
                String tShirt
        ) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.bio = bio;
            this.careers = careers;
            this.preferredLanguage = preferredLanguage;
            this.tShirt = tShirt;
        }

        public String username() {
            return username;
        }

        public String email() {
            return email;
        }

        public String password() {
            return password;
        }

        public String bio() {
            return bio;
        }

        public List<String> careers() {
            return careers;
        }

        public String preferredLanguage() {
            return preferredLanguage;
        }

        public String tShirt() {
            return tShirt;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Developer) obj;
            return Objects.equals(this.username, that.username) &&
                    Objects.equals(this.email, that.email) &&
                    Objects.equals(this.password, that.password) &&
                    Objects.equals(this.bio, that.bio) &&
                    Objects.equals(this.careers, that.careers) &&
                    Objects.equals(this.preferredLanguage, that.preferredLanguage) &&
                    Objects.equals(this.tShirt, that.tShirt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, email, password, bio, careers, preferredLanguage, tShirt);
        }

        @Override
        public String toString() {
            return "Developer[" +
                    "username=" + username + ", " +
                    "email=" + email + ", " +
                    "password=" + password + ", " +
                    "bio=" + bio + ", " +
                    "careers=" + careers + ", " +
                    "preferredLanguage=" + preferredLanguage + ", " +
                    "tShirt=" + tShirt + ']';
        }

    }
}
