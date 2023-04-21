package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eamapp.crud.crudspringboot.entity.Client;
import com.eamapp.crud.crudspringboot.repositorie.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> allClients() {
        return repository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    };
}
