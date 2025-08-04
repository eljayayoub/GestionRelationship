package com.example.GestionRelationship.controller;

import com.example.GestionRelationship.entities.Orders;
import com.example.GestionRelationship.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @PostMapping
    public Orders add(@RequestBody Orders o) {
        return service.save(o);
    }

    @GetMapping
    public List<Orders> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
