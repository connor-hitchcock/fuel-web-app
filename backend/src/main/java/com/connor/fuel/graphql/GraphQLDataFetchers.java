package com.connor.fuel.graphql;

import com.connor.fuel.data.CarDetailData;
import com.connor.fuel.data.FuelPriceData;
import com.connor.fuel.data.PersonCarData;
import com.connor.fuel.data.PersonData;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {
    //Using hardcoded data at the moment

    public DataFetcher getCarDetailsDataFetcher() {
        return env -> CarDetailData.allCarDetailsMapped;
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> FuelPriceData.allFuelPricesMapped;
    }

    public DataFetcher getPersonDataFetcher() {
        return env -> PersonData.allPeopleMapped;
    }

    public DataFetcher getPersonCarDataFetcher() {
        return env -> PersonCarData.allPersonCarsMapped;
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return CarDetailData.allCarDetailsMapped
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
            return FuelPriceData.allFuelPricesMapped
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonByIDDataFetcher() {
        return env -> {
            Map<String, Object> personObj = env.getSource();
            int personID = (int) personObj.get("personID");
            return PersonData.allPeopleMapped
                    .stream()
                    .filter(person -> person.get("personID").equals(personID))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPeopleByFirstNameDataFetcher() {
        return env -> {
            Map<String, Object> personObj = env.getSource();
            String firstName = (String) personObj.get("firstName");
            return PersonData.allPeopleMapped
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
            return PersonData.allPeopleMapped
                    .stream()
                    .filter(person -> person.get("firstName").equals(firstName))
                    .filter(person -> person.get("lastName").equals(lastName))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarsByPersonIDDataFetcher() {
        return env -> {
            Map<String, Object> personCarObj = env.getSource();
            int personID = (int) personCarObj.get("personID");
            return PersonCarData.allPersonCarsMapped
                    .stream()
                    .filter(personCar -> personCar.get("personID").equals(personID))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarsByLicensePlateDataFetcher() {
        return env -> {
            Map<String, Object> personCarObj = env.getSource();
            String licensePlate = (String) personCarObj.get("licensePlate");
            return PersonCarData.allPersonCarsMapped
                    .stream()
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findAny()
                    .orElse(null);
        };
    }

    public DataFetcher getPersonCarByIDLicensePlateDataFetcher() {
        return env -> {
            Map<String, Object> personCarObj = env.getSource();
            int personID = (int) personCarObj.get("personID");
            String licensePlate = (String) personCarObj.get("licensePlate");
            return PersonCarData.allPersonCarsMapped
                    .stream()
                    .filter(personCar -> personCar.get("personID").equals(personID))
                    .filter(personCar -> personCar.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }
}
