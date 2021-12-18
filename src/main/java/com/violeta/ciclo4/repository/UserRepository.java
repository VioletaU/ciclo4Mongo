/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.violeta.ciclo4.repository;

import com.violeta.ciclo4.interfaces.UserInterface;
import com.violeta.ciclo4.model.Order;
import com.violeta.ciclo4.model.User;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.aggregation.DateOperators.Month.month;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mavi0
 */
@Repository
public class UserRepository {

    @Autowired
    private UserInterface userCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public List<User> getUseBirthday(String month) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(month(month));
        query.addCriteria(dateCriteria);
        List<User> users = mongoTemplate.find(query, User.class);

        return users;
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> lasUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }

}
