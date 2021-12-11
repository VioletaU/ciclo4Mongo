/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.violeta.ciclo4.interfaces;

import com.violeta.ciclo4.model.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author mavi0
 */
public interface CookwareInterface extends MongoRepository<Cookware, String> {

}
