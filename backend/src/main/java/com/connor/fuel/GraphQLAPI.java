package com.connor.fuel;

import com.connor.fuel.controller.DatabaseController;
import com.connor.fuel.controller.Logic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQLAPI {

    public static void main(String[] args) {
        DatabaseController.updateFuelCosts();
        SpringApplication.run(GraphQLAPI.class, args);
    }
}
