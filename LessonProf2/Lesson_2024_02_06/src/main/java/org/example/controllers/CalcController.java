package org.example.controllers;

import org.example.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CalcController {

    private final CalcService service;

    @Autowired
    public CalcController(CalcService service) {
        this.service = service;
    }

    @GetMapping("/calc")
    public String calculate(
            @RequestParam(value = "op", defaultValue = "") String op,
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            Model model) {
        int result = service.calculate(op, num1, num2);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("op", op);
        model.addAttribute("result", result);
        return "show_calc.html";
    }
}
