package com.eamapp.crud.crudspringboot.controller;

import com.eamapp.crud.crudspringboot.entity.Client;
// import com.eamapp.crud.crudspringboot.clientService.DepartamentoServicio;
import com.eamapp.crud.crudspringboot.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private RegionService serviceRegion;

    @GetMapping({ "/clients"})
    public String GetAllClients(Model modelo) {
        modelo.addAttribute("clients", clientService.allClients());
        return "clients"; // nos retorna al archivo clientes
    }

    @GetMapping("/clients/new")
    public String showClientsForm(Model modelo) {
        Client client = new Client();
        modelo.addAttribute("client", client);
        modelo.addAttribute("regionList", serviceRegion.allRegions());
        return "create_client";
    }

    @PostMapping("/clients")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("client", clientService.getClientById(id));
        modelo.addAttribute("regionList", serviceRegion.allRegions());
        return "edit_client";
    }

    @PostMapping("/clients/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client,
            Model modelo) {
        Client existingClient = clientService.getClientById(id);
        existingClient.setId(id);
        existingClient.setName(client.getName());
        existingClient.setLastname1(client.getLastname1());
        existingClient.setLastname2(client.getLastname2());
        existingClient.setRegion(client.getRegion());
        existingClient.setCategory(client.getCategory());

        clientService.updateClient(existingClient);
        return "redirect:/clients";
    }

    @GetMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
