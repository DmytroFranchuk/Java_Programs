package org.example.controller;

import org.example.dto.DishDto;
import org.example.service.ServiceMenu;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/menu")
public class DishController {

    private final ServiceMenu serviceMenu;
    @Autowired
    public DishController(ServiceMenu serviceMenu) {
        this.serviceMenu = serviceMenu;
    }

    @GetMapping(path = "/dishes")
    public DishDto getDish(@RequestParam(name = "name") String name) {
        return serviceMenu.getByName(name);
    }
}
