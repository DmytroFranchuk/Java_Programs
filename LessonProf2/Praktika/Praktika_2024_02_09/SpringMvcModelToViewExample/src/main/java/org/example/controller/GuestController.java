package org.example.controller;

import org.example.entity.Guest;
import org.example.entity.GuestRegistrationForm;
import org.springframework.ui.Model;
import org.example.service.GuestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/create")
    public String createGuest(Model model) {
        model.addAttribute("guestDto", new GuestRegistrationForm(0, ""));
        return "guest_registration";
    }

    @PostMapping("/create")
    public String postGuest(@ModelAttribute("guestDto") GuestRegistrationForm guest, Model model) {
        if (guestService.isThereGuest(guest.id())) {
            Guest existed = guestService.getById(guest.id());
            guestService.addOrder(guest.id());
            model.addAttribute("name", existed.name());
            model.addAttribute("discount", existed.order() * 5);
            return "guest_welcome";
        }
        model.addAttribute("guestDto", guestService.createGuest(guest.name()));
        return "guest_created";
    }
}
