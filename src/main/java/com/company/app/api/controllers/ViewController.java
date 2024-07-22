package com.company.app.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/", "/index"})
    public String home() {
        return "index";
    }

    @GetMapping("/projetos")
    public String projetos() {
        return "projetos/view";
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


