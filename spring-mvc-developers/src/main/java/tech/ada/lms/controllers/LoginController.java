package tech.ada.lms.controllers;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.ada.lms.model.User;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final InMemoryUserDetailsManager userManager;

    public LoginController(InMemoryUserDetailsManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        this.userManager.createUser(org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername()).password("{noop}" + user.getPassword()).roles("USER").build());
        return "register-successfully";
    }
}
