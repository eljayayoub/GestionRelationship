package com.example.GestionRelationship.controller;

import com.example.GestionRelationship.entities.Client;
import com.example.GestionRelationship.entities.Orders;
import com.example.GestionRelationship.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/ville/{ville}")
    public List<Client> getByVille(@PathVariable String ville) {
        return service.getClientsByVille(ville);
    }

    @GetMapping("/nom/{nom}")
    public List<Client> getByNom(@PathVariable String nom) {
        return service.getClientsByNom(nom);
    }

    @GetMapping("/count/ville/{ville}")
    public Long countByVille(@PathVariable String ville) {
        return service.countClientsByVille(ville);
    }

    @GetMapping("/{id}/orders")
    public List<Orders> getOrdersByClientId(@PathVariable Long id) {
        return service.getOrdersByClientId(id);
    }
}
