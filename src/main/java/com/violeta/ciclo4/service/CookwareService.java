/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.service;

import com.violeta.ciclo4.model.Cookware;
import com.violeta.ciclo4.repository.CookwareRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mavi0
 */
@Service
public class CookwareService {

    @Autowired
    private CookwareRepository cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getClothe(String reference) {
        return cookwareRepository.getClothe(reference);
    }

    public Cookware create(Cookware cookware) {
        if (cookware.getReference() == null) {
            return cookware;
        } else {
            return cookwareRepository.create(cookware);
        }
    }

    public Cookware update(Cookware cookware) {
        if (cookware.getReference() != null) {
            Optional<Cookware> cookwareDb = cookwareRepository.getClothe(cookware.getReference());
            if (!cookwareDb.isEmpty()) {
                if (cookware.getReference() != null) {
                    cookwareDb.get().setReference(cookware.getReference());
                }
                if (cookware.getBrand()!= null) {
                    cookwareDb.get().setBrand(cookware.getBrand());
                }
                if (cookware.getCategory() != null) {
                    cookwareDb.get().setCategory(cookware.getCategory());
                }
                if (cookware.getMateriales()!= null) {
                    cookwareDb.get().setMateriales(cookware.getMateriales());
                } 
                if (cookware.getDimensiones()!= null) {
                    cookwareDb.get().setDimensiones(cookware.getDimensiones());
                }
                if (cookware.getDescription() != null) {
                    cookwareDb.get().setDescription(cookware.getDescription());
                }
                if (cookware.getPrice() != 0.0) {
                    cookwareDb.get().setPrice(cookware.getPrice());
                }
                if (cookware.getQuantity() != 0) {
                    cookwareDb.get().setQuantity(cookware.getQuantity());
                }
                if (cookware.getPhotography() != null) {
                    cookwareDb.get().setPhotography(cookware.getPhotography());
                }
                cookwareDb.get().setAvailability(cookware.isAvailability());
                cookwareRepository.update(cookwareDb.get());
                return cookwareDb.get();
            } else {
                return cookware;
            }
        } else {
            return cookware;
        }
    }

    public boolean delete(String reference) {
        boolean del = getClothe(reference).map(clothe -> {
            cookwareRepository.delete(clothe);
            return true;
        }).orElse(false);
        return del;
    }
}
