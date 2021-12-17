/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.violeta.ciclo4.interfaces;

import com.violeta.ciclo4.model.Order;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author mavi0
 */
public interface OrderInterface extends MongoRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesManId(final int id);

    @Query("{'status': ?0}")
    List<Order> findByStatus(final String status);

    @Query("{'status': ?0, 'salesMan.id': ?1}")
    List<Order> findByStatusSalesManId(final String status, final int id);

    @Query("{'registerDay': ?0, 'salesMan.id': ?1}")
    List<Order> findByDateSalesManId(final LocalDate date, final int id);

    Optional<Order> findTopByOrderByIdDesc();
}
