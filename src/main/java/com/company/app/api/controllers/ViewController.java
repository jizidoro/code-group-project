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
        return "projetos/view";
    }

    @GetMapping("/membros")
    public String membros() {
        return "membros";
    }

    @GetMapping("/projetos/form")
    public String projetosForm() {
        return "projetos/form";
    }

    @GetMapping("/projetos/detalhes")
    public String projetosDetalhes() {
        return "projetos/detalhes";
    }
}


