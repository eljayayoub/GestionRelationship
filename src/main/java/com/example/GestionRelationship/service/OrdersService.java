package com.example.GestionRelationship.service;

import com.example.GestionRelationship.entities.Orders;
import com.example.GestionRelationship.repos.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders save(Orders o) {
        return ordersRepository.save(o);
    }

    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getById(Long id) {
        return ordersRepository.findById(id);
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}
