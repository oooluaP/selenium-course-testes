package tech.ada.lms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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

    public record Developer(
            String username,
            String email,
            String password,
            String bio,
            List<String> careers,
            String preferredLanguage
    ) {
    }
}
