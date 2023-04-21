package com.eamapp.crud.crudspringboot.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eamapp.crud.crudspringboot.repositorie.ClientRepository;

@Controller
public class IndexController {

    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/")
    public String seeHomePage(Model model){
        List<Object[]> clientsWithOrders = clientRepository.clientsWithOrders();
        model.addAttribute("clientsWithOrders", clientsWithOrders);
        List<Object[]> clientsWithoutOrders = clientRepository.clientsWithoutOrders();
        model.addAttribute("clientsWithoutOrders", clientsWithoutOrders);
        return "index";
    }



}
