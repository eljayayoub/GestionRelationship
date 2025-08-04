package com.example.GestionRelationship.repos;

import com.example.GestionRelationship.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
