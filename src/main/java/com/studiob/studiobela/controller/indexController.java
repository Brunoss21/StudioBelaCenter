package com.studiob.studiobela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.studiob.studiobela.model.Atendimento;
import com.studiob.studiobela.model.AtendimentoService;

@Controller
public class indexController {

    @Autowired private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping("/agenda")
    public String agendar(Model model) {
        model.addAttribute("atendimento", new Atendimento());
        return "agenda";
    }


    @PostMapping("/agenda")
    public String enviar(RedirectAttributes redirectAttributes, @ModelAttribute Atendimento ati) {
        AtendimentoService at = context.getBean(AtendimentoService.class);
        at.inserirAtendimento(ati);
        return "redirect:/sucesso"; 
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        AtendimentoService at = context.getBean(AtendimentoService.class);
        List<Map<String,Object>> lista = at.listarAtendimentos();
        model.addAttribute("lista", lista);
        return "dashboard";
    }


}
