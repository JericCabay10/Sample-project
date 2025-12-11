package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostMappingController {

    @PostMapping("/home")
    public String home(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String billBySomeoneElse,
            Model model
    ) {
        model.addAttribute("name", name);

        if ("on".equals(billBySomeoneElse)) {
            model.addAttribute("phone", phone);
            model.addAttribute("email", email);
        } else {
            model.addAttribute("phone", phone);
            model.addAttribute("email", "N/A (mandatory if bill not made by someone else)");
        }

        return "home";
    }
}
