package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import com.eamapp.crud.crudspringboot.entity.Client;

public interface ClientService {
    public List<Client> allClients();

    public Client saveClient(Client client);

    public Client getClientById(Long id);

    public Client updateClient(Client client);

    public void deleteClient(Long id);
}