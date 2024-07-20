package com.company.app.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/projetos")
    public String projetos() {
        return "projetos";
    }

    @GetMapping("/membros")
    public String membros() {
        return "membros";
    }
}
