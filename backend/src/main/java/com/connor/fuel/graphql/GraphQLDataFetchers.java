package com.connor.fuel.graphql;

import com.connor.fuel.controller.DatabaseController;
import graphql.language.Field;
import graphql.language.SelectionSet;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {
    public boolean findFieldNameEnv(DataFetchingEnvironment env, String fieldName) {
        return findFieldName(env.getMergedField().getSingleField().getSelectionSet(), fieldName);
    }

    public boolean findFieldName(SelectionSet selectionSet, String fieldName) {
        for (var fieldObj: selectionSet.getSelections()) {
            var field = (Field) fieldObj;
            var subSelectionSet = field.getSelectionSet();
            if (Objects.equals(field.getName(), fieldName)) {
                return true;
            } else if (subSelectionSet != null) {
                return findFieldName(subSelectionSet, fieldName);
            }
        }
        return false;
    }

    public DataFetcher getPersonDataFetcher() {
        return env -> {
            boolean getOwnedCars = findFieldNameEnv(env, "ownedCars");
            boolean getCar = findFieldNameEnv(env, "car");
            boolean getFuelPrice = findFieldNameEnv(env, "fuelPrice");
            return DatabaseController.getAllPeopleFromDB(getOwnedCars, getCar, getFuelPrice);
        };
    }

    public DataFetcher getPersonCarDataFetcher() {
        return env -> {
            boolean getCar = findFieldNameEnv(env, "car");
            boolean getFuelPrice = findFieldNameEnv(env, "fuelPrice");
            return DatabaseController.getAllPersonCarsFromDB(null, getCar, getFuelPrice);
        };
    }

    public DataFetcher getCarDetailsDataFetcher() {
        return env -> {
            boolean getFuelPrice = findFieldNameEnv(env, "fuelPrice");
            return DatabaseController.getAllCarDetailsFromDB(null, getFuelPrice);
        };
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> DatabaseController.getAllFuelPricesFromDB(null);
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllCarDetailsFromDB(null, false)
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
            return DatabaseController.getAllPeopleFromDB(false, false, false)
                    .stream()
                    .filter(person -> person.get("email").equals(email))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            return DatabaseController.getAllPeopleFromDB(false, false, false)
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPeopleByFirstLastNameDataFetcher() {
        return env -> {
            String firstName = env.getArgument("firstName");
            String lastName = env.getArgument("lastName");
            return DatabaseController.getAllPeopleFromDB(false, false, false)
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .filter(person -> person.get("lastName").equals(lastName))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByEmailDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            return DatabaseController.getAllPersonCarsFromDB(null, false, false)
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB(null, false, false)
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .collect(Collectors.toList());
        };
    }

    public DataFetcher getPersonCarByEmailLicensePlateDataFetcher() {
        return env -> {
            String email = env.getArgument("email");
            String licensePlate = env.getArgument("licensePlate");
            return DatabaseController.getAllPersonCarsFromDB(null, false, false)
                    .stream()
                    .filter(personCar -> personCar.get("email").equals(email))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
