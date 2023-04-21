package com.eamapp.crud.crudspringboot.controller;

import com.eamapp.crud.crudspringboot.entity.Order;
import com.eamapp.crud.crudspringboot.service.ClientService;
import com.eamapp.crud.crudspringboot.service.ComercialService;
// import com.eamapp.crud.crudspringboot.serviceOrder.DepartamentoServicio;
import com.eamapp.crud.crudspringboot.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService serviceOrder;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ComercialService serviceComercial;

    @GetMapping({ "/orders"})
    public String GetAllOrders(Model modelo) {
        modelo.addAttribute("orders", serviceOrder.allOrders());
        return "orders"; // nos retorna al archivo orderes
    }

    @GetMapping("/orders/new")
    public String showOrdersForm(Model modelo) {
        Order order = new Order();
        modelo.addAttribute("order", order);
        modelo.addAttribute("clientList", clientService.allClients());
        modelo.addAttribute("comercialList", serviceComercial.allComercials());
        return "create_order";
    }

    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute("order") Order order) {
        serviceOrder.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("order", serviceOrder.getOrderById(id));
        modelo.addAttribute("clientList", clientService.allClients());
        modelo.addAttribute("comercialList", serviceComercial.allComercials());
        return "edit_order";
    }

    @PostMapping("/orders/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute("order") Order order,
            Model modelo) {
        Order existingOrder = serviceOrder.getOrderById(id);
        existingOrder.setId(id);
        existingOrder.setAmount(order.getAmount());
        existingOrder.setDate(order.getDate());
        existingOrder.setClient(order.getClient());
        existingOrder.setComercial(order.getComercial());

        serviceOrder.updateOrder(existingOrder);
        return "redirect:/orders";
    }

    @GetMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        serviceOrder.deleteOrder(id);
        return "redirect:/orders";
    }
}
