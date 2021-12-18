/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.violeta.ciclo4.interfaces;

import com.violeta.ciclo4.model.Cookware;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author mavi0
 */
public interface CookwareInterface extends MongoRepository<Cookware, String> {

    @Query("{'price': {$lt:?0}}")
    public List<Cookware> findByPrice(final String price);

    @Query("{'description': {$regex: ?0, $options: 'i'}}")
    public List<Cookware> findByDescription(final String description);
}
