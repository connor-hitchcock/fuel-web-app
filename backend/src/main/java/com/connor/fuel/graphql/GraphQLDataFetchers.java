package com.connor.fuel.graphql;

import com.connor.fuel.controller.DatabaseController;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {
    //Using hardcoded data at the moment

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
            Map<String, Object> fuelPriceObj = env.getSource();
            String country = (String) fuelPriceObj.get("country");
            return DatabaseController.getAllFuelPricesFromDB()
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonByEmailDataFetcher() {
        return env -> {
            Map<String, Object> personObj = env.getSource();
            String email = (String) personObj.get("email");
            return DatabaseController.getAllPeopleFromDB()
                    .stream()
                    .filter(person -> person.get("email").equals(email))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            Map<String, Object> personObj = env.getSource();
            String firstName = (String) personObj.get("firstName");
            return DatabaseController.getAllPeopleFromDB()
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstLastNameDataFetcher() {
        return env -> {
            Map<String, Object> personObj = env.getSource();
            String firstName = (String) personObj.get("firstName");
            String lastName = (String) personObj.get("lastName");
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
            Map<String, Object> personCarObj = env.getSource();
            String personID = (String) personCarObj.get("email");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(personID))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            Map<String, Object> personCarObj = env.getSource();
            String licensePlate = (String) personCarObj.get("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarByEmailLicensePlateDataFetcher() {
        return env -> {
            Map<String, Object> personCarObj = env.getSource();
            String personID = (String) personCarObj.get("email");
            String licensePlate = (String) personCarObj.get("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB()
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(personID))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
