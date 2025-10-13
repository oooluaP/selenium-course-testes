package tech.ada.lms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.ada.lms.model.Developer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperController {


    private static final List<Developer> DEVELOPERS_LIST = new ArrayList<>();

    @GetMapping("/create-developer")
    public String createDeveloper(Model model) {
        model.addAttribute("developer",
                new Developer());
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
        DEVELOPERS_LIST.removeIf(dev -> dev.getUsername().equals(username));
        model.addAttribute("developers", DEVELOPERS_LIST);
        return "list-developers";
    }
}
