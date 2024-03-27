package tech.ada.lms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class DeveloperController {


    private static final List<Developer> DEVELOPERS_LIST = new ArrayList<>();

    @GetMapping("/create-developer")
    public String createDeveloper(Model model) {
        model.addAttribute("developer",
                new DeveloperController.Developer());
        return "create-developer";
    }


    @GetMapping("/list-developers")
    public String listDevelopers(Model model) {
        model.addAttribute("developers", DEVELOPERS_LIST);
        System.out.println(DEVELOPERS_LIST);
        return "list-developers";
    }

    @PostMapping("/create-developer")
    public String createNewDeveloper(@Valid Developer developer, BindingResult bindingResult, Model model) {
        System.out.println(developer);
        if (bindingResult.hasErrors()) {
            return "create-developer";
        }
        DEVELOPERS_LIST.add(developer);
        return "redirect:/list-developers";
    }

    @GetMapping("/delete-developer/{username}")
    public String deleteDeveloper(@PathVariable("username") String username, Model model) {
        DEVELOPERS_LIST.removeIf(dev -> dev.username.equals(username));
        model.addAttribute("developers", DEVELOPERS_LIST);
        return "list-developers";
    }

    public static final class Developer {

        @NotBlank
        @Size(min = 3, max = 20)
        private String username;
        @Email
        @NotBlank
        private String email;
        @Size(min = 6, max = 16)
        private String password;
        @Size(min = 50, max = 200)
        @NotBlank
        private String bio;
        @Size(min = 1, max = 4)
        @NotNull
        private List<String> careers;
        @NotBlank
        @NotNull
        private String preferredLanguage;
        @NotBlank
        @NotNull
        private String tShirt;

        public Developer() {
        }

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public List<String> getCareers() {
            return careers;
        }

        public void setCareers(List<String> careers) {
            this.careers = careers;
        }

        public String getPreferredLanguage() {
            return preferredLanguage;
        }

        public void setPreferredLanguage(String preferredLanguage) {
            this.preferredLanguage = preferredLanguage;
        }

        public String gettShirt() {
            return tShirt;
        }

        public void settShirt(String tShirt) {
            this.tShirt = tShirt;
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
