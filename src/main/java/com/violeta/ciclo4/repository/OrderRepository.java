/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.repository;

import com.violeta.ciclo4.interfaces.OrderInterface;
import com.violeta.ciclo4.model.Order;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mavi0
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderInterface orderInterface;

    public List<Order> getAll() {
        return (List<Order>) orderInterface.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderInterface.findById(id);
    }

    public Order create(Order order) {
        return orderInterface.save(order);
    }

    public void update(Order order) {
        orderInterface.save(order);
    }

    public void delete(Order order) {
        orderInterface.delete(order);
    }

    public Optional<Order> lasOrderId() {
        return orderInterface.findTopByOrderByIdDesc();
    }

    public List<Order> getOrdersZona(String zona) {
        return orderInterface.findByZone(zona);
    }

    public List<Order> getOrdersSalesManId(int id) {
        return orderInterface.findBySalesManId(id);
    }

    public List<Order> findByStatusSalesManId(String status, int id) {
        return orderInterface.findByStatusSalesManId(status, id);
    }

    public List<Order> findByDateSalesManId(LocalDate date, int id) {
        return orderInterface.findByDateSalesManId(date, id);
    }
}
