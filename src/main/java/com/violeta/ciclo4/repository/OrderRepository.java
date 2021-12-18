/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.repository;

import com.violeta.ciclo4.interfaces.OrderInterface;
import com.violeta.ciclo4.model.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mavi0
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderInterface orderInterface;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<Order> findByDateSalesManId(String date, int id) {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(date, dft).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(date, dft).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
}
