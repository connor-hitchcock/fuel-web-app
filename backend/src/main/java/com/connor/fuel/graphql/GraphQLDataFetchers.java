package com.connor.fuel.graphql;

import com.connor.fuel.controller.DatabaseController;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {
    //TODO owned car graphql query does not work

    public DataFetcher getCarDetailsDataFetcher() {
        return env -> DatabaseController.getAllCarDetailsFromDB();
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> DatabaseController.getAllFuelPricesFromDB();
    }

    public DataFetcher getPersonDataFetcher() {
        return env -> DatabaseController.getAllPeopleFromDB();
    }

    public DataFetcher getPersonCarDataFetcher() {
        return env -> DatabaseController.getAllPersonCarsFromDB();
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllCarDetailsFromDB()
                    .stream()
                    .filter(carDetail -> carDetail.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getFuelPriceDataFetcher() {
        return env -> {
            String country = env.getArgument("country");
            return DatabaseController.getAllFuelPricesFromDB()
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            return DatabaseController.getAllPeopleFromDB()
                    .stream()
                    .filter(person -> person.get("email").equals(email))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            return DatabaseController.getAllPeopleFromDB()
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstLastNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            String lastName = env.getArgument("lastName");
            return DatabaseController.getAllPeopleFromDB()
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .filter(person -> person.get("lastName").equals(lastName))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarsByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarByEmailLicensePlateDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
