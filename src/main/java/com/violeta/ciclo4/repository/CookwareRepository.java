/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.repository;

import com.violeta.ciclo4.interfaces.CookwareInterface;
import com.violeta.ciclo4.model.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mavi0
 */
@Repository
public class CookwareRepository {

    @Autowired
    private CookwareInterface cookwareInterface;

    public List<Cookware> getAll() {
        return cookwareInterface.findAll();
    }

    public Optional<Cookware> getClothe(String reference) {
        return cookwareInterface.findById(reference);
    }

    public Cookware create(Cookware cookware) {
        return cookwareInterface.save(cookware);
    }

    public void update(Cookware cookware) {
        cookwareInterface.save(cookware);
    }

    public void delete(Cookware cookware) {
        cookwareInterface.delete(cookware);
    }
}
