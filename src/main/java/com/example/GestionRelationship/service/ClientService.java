package com.example.GestionRelationship.service;

import com.example.GestionRelationship.entities.Client;
import com.example.GestionRelationship.entities.Orders;
import com.example.GestionRelationship.repos.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client c) {
        return clientRepository.save(c);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getClientsByVille(String ville) {
        return clientRepository.findByVille(ville);
    }

    public List<Client> getClientsByNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public Long countClientsByVille(String ville) {
        return clientRepository.countByVille(ville);
    }

    public List<Orders> getOrdersByClientId(Long clientId) {
        return clientRepository.findById(clientId)
                .map(Client::getOrders)
                .orElse(Collections.emptyList());
    }
}
