package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FirstController {

    @GetMapping("/first")
    public String showFirst(@RequestParam(name = "name") String name,
                            RedirectAttributes attributes) {
        System.out.println("get name" + name);
        attributes.addAttribute("name", name);
        return "redirect:/second";
    }


}

