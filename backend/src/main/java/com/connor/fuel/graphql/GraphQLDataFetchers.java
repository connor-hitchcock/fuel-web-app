package com.connor.fuel.graphql;

import com.connor.fuel.controller.DatabaseController;
import graphql.language.Field;
import graphql.language.SelectionSet;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {
    public Map<String, Boolean> findFieldNamesEnv(DataFetchingEnvironment env, List<String> fieldNames) {
        var foundFieldNames = new HashMap<String, Boolean>();
        for (String fieldName: fieldNames) {
            foundFieldNames.put(fieldName, false);
        }
        var selectionSet = env.getMergedField().getSingleField().getSelectionSet();
        return findFieldNames(selectionSet, foundFieldNames);
    }

    public Map<String, Boolean> findFieldNames(SelectionSet selectionSet, Map<String, Boolean> foundFieldNames) {
        for (var fieldObj: selectionSet.getSelections()) {
            var field = (Field) fieldObj;
            if (foundFieldNames.get(field.getName()) != null) {
                foundFieldNames.put(field.getName(), true);
            }
            var subSelectionSet = field.getSelectionSet();
            if (subSelectionSet != null) {
                findFieldNames(subSelectionSet, foundFieldNames);
            }
        }
        return foundFieldNames;
    }

    public DataFetcher getPersonDataFetcher() {
        return env -> {
            var gets = findFieldNamesEnv(env, List.of("ownedCars", "car", "fuelPrice"));
            return DatabaseController.getAllPeopleFromDB(gets.get("ownedCars"), gets.get("car"), gets.get("fuelPrice"));
        };
    }

    public DataFetcher getPersonCarDataFetcher() {
        return env -> {
            var gets = findFieldNamesEnv(env, List.of("car", "fuelPrice"));
            return DatabaseController.getAllPersonCarsFromDB(null, gets.get("car"), gets.get("fuelPrice"));
        };
    }

    public DataFetcher getCarDetailsDataFetcher() {
        return env -> {
            var gets = findFieldNamesEnv(env, List.of("fuelPrice"));
            return DatabaseController.getAllCarDetailsFromDB(null, gets.get("fuelPrice"));
        };
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> DatabaseController.getAllFuelPricesFromDB(null);
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            var gets = findFieldNamesEnv(env, List.of("fuelPrice"));
            return DatabaseController.getAllCarDetailsFromDB(null, gets.get("fuelPrice"))
                    .stream()
                    .filter(carDetail -> carDetail.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getFuelPriceDataFetcher() {
        return env -> {
            String country = env.getArgument("country");
            return DatabaseController.getAllFuelPricesFromDB(null)
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            var gets = findFieldNamesEnv(env, List.of("ownedCars", "car", "fuelPrice"));
            return DatabaseController.getAllPeopleFromDB(gets.get("ownedCars"), gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(person -> person.get("email").equals(email))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            var gets = findFieldNamesEnv(env, List.of("ownedCars", "car", "fuelPrice"));
            return DatabaseController.getAllPeopleFromDB(gets.get("ownedCars"), gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPeopleByFirstLastNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            String lastName = env.getArgument("lastName");
            var gets = findFieldNamesEnv(env, List.of("ownedCars", "car", "fuelPrice"));
            return DatabaseController.getAllPeopleFromDB(gets.get("ownedCars"), gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .filter(person -> person.get("lastName").equals(lastName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            var gets = findFieldNamesEnv(env, List.of("ownedCars", "car", "fuelPrice"));
            return DatabaseController.getAllPeopleFromDB(gets.get("ownedCars"), gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            var gets = findFieldNamesEnv(env, List.of("car", "fuelPrice"));
            return DatabaseController.getAllPersonCarsFromDB(null, gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarByEmailLicensePlateDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            String licensePlate = env.getArgument("licensePlate");
            var gets = findFieldNamesEnv(env, List.of("car", "fuelPrice"));
            return DatabaseController.getAllPersonCarsFromDB(null, gets.get("car"), gets.get("fuelPrice"))
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
