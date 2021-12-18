package com.violeta.ciclo4;

import com.violeta.ciclo4.interfaces.CookwareInterface;
import com.violeta.ciclo4.interfaces.OrderInterface;
import com.violeta.ciclo4.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Ciclo4Application implements CommandLineRunner {

    @Autowired
    private CookwareInterface cookwareInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;

    public static void main(String[] args) {
        SpringApplication.run(Ciclo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /* cookwareInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll(); */
    }
}
