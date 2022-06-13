package com.connor.fuel.graphql;

import com.connor.fuel.controller.DatabaseController;
import graphql.language.Field;
import graphql.language.Selection;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {

    public DataFetcher getCarDetailsDataFetcher() {
        return env -> DatabaseController.getAllCarDetailsFromDB();
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> DatabaseController.getAllFuelPricesFromDB();
    }

    public DataFetcher getPersonDataFetcher() {
        return env -> {
            boolean getOwnedCars = false;
            var selections = env.getMergedField().getSingleField().getSelectionSet().getSelections();
            for (var fieldObj: selections) {
                var field = (Field) fieldObj;
                if (Objects.equals(field.getName(), "ownedCars")) {
                    getOwnedCars = true;
                    break;
                }
            }
            return DatabaseController.getAllPeopleFromDB(getOwnedCars);
        };
    }

    public DataFetcher getPersonCarDataFetcher() {
        return env -> DatabaseController.getAllPersonCarsFromDB(null);
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
            return DatabaseController.getAllPeopleFromDB(false)
                    .stream()
                    .filter(person -> person.get("email").equals(email))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            return DatabaseController.getAllPeopleFromDB(false)
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPeopleByFirstLastNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            String lastName = env.getArgument("lastName");
            return DatabaseController.getAllPeopleFromDB(false)
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .filter(person -> person.get("lastName").equals(lastName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            return DatabaseController.getAllPersonCarsFromDB(null)
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB(null)
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarByEmailLicensePlateDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB(null)
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
