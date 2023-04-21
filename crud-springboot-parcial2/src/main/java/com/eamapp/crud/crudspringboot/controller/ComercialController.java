package com.eamapp.crud.crudspringboot.controller;

import com.eamapp.crud.crudspringboot.entity.Comercial;
// import com.eamapp.crud.crudspringboot.serviceComercial.DepartamentoServicio;
import com.eamapp.crud.crudspringboot.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComercialController {
    @Autowired
    private ComercialService serviceComercial;

    @Autowired
    private RegionService serviceRegion;

    @GetMapping({ "/comercials"})
    public String GetAllComercials(Model modelo) {
        modelo.addAttribute("comercials", serviceComercial.allComercials());
        return "comercials"; // nos retorna al archivo comerciales
    }

    @GetMapping("/comercials/new")
    public String showComercialsForm(Model modelo) {
        Comercial comercial = new Comercial();
        modelo.addAttribute("comercial", comercial);
        modelo.addAttribute("regionList", serviceRegion.allRegions());
        // modelo.addAttribute("listaDepartamentos", serviceRegion.listarTodosLosDepartamentos());
        return "create_comercial";
    }

    @PostMapping("/comercials")
    public String saveComercial(@ModelAttribute("comercial") Comercial comercial) {
        serviceComercial.saveComercial(comercial);
        return "redirect:/comercials";
    }

    @GetMapping("/comercials/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("comercial", serviceComercial.getComercialById(id));
        modelo.addAttribute("regionList", serviceRegion.allRegions());
        return "edit_comercial";
    }

    @PostMapping("/comercials/{id}")
    public String updateComercial(@PathVariable Long id, @ModelAttribute("comercial") Comercial comercial,
            Model modelo) {
        Comercial existingComercial = serviceComercial.getComercialById(id);
        existingComercial.setId(id);
        existingComercial.setName(comercial.getName());
        existingComercial.setLastname1(comercial.getLastname1());
        existingComercial.setLastname2(comercial.getLastname2());
        existingComercial.setRegion(comercial.getRegion());
        existingComercial.setComission(comercial.getComission());

        serviceComercial.updateComercial(existingComercial);
        return "redirect:/comercials";
    }

    @GetMapping("/comercials/{id}")
    public String deleteComercial(@PathVariable Long id) {
        serviceComercial.deleteComercial(id);
        return "redirect:/comercials";
    }
}
