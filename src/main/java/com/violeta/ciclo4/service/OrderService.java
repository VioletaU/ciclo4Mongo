/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.service;

import com.violeta.ciclo4.model.Order;
import com.violeta.ciclo4.repository.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mavi0
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public List<Order> getOrdersZona(String zona) {
        return orderRepository.getOrdersZona(zona);
    }

    public List<Order> getOrdersSalesManId(int id) {
        return orderRepository.getOrdersSalesManId(id);
    }

    public List<Order> findByStatusSalesManId(String status, int id) {
        return orderRepository.findByStatusSalesManId(status, id);
    }

    public List<Order> findByDateSalesManId(String dateStr, int id) {
        return orderRepository.findByDateSalesManId(dateStr, id);
    }

    public Order create(Order order) {
        Optional<Order> orderIdMaximo = orderRepository.lasOrderId();

        if (order.getId() == null) {
            order.setId(orderIdMaximo.isEmpty() ? 1 : orderIdMaximo.get().getId() + 1);
        }

        Optional<Order> e = orderRepository.getOrder(order.getId());

        if (e.isEmpty()) {
            return orderRepository.create(order);
        } else {
            return order;
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        boolean del = getOrder(id).map(clothe -> {
            orderRepository.delete(clothe);
            return true;
        }).orElse(false);
        return del;
    }

}
